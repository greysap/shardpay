package house.greysap.shardpay.repository.impl;

import house.greysap.shardpay.dto.PaymentDto;
import house.greysap.shardpay.entity.tables.Payment;
import house.greysap.shardpay.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import static org.jooq.impl.DSL.sum;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository<PaymentDto> {

    private final DSLContext dsl;
    private final Payment table = Payment.PAYMENT;

    @Override
    public void bulkInsert(List<PaymentDto> paymentDtos) {
        // Although JOOQ has batchInsert method, it has a couple of issues with performance:
        // https://github.com/jOOQ/jOOQ/issues/4533
        // https://github.com/jOOQ/jOOQ/issues/6294
        // Hence the simple insert.
        for (PaymentDto dto : paymentDtos) {
            dsl.insertInto(table)
                    .set(table.PAYER, dto.getPayer())
                    .set(table.PAYEE, dto.getPayee())
                    .set(table.AMOUNT, dto.getAmount())
                    .execute();
        }
    }

    @Override
    public BigDecimal sumByPayer(Long payer) {
        return dsl.select(sum(table.AMOUNT)).from(table).where(table.PAYER.eq(payer)).fetchOne().value1();
    }
}
