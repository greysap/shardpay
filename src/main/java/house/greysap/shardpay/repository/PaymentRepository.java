package house.greysap.shardpay.repository;


import java.math.BigDecimal;
import java.util.List;

public interface PaymentRepository<PaymentDto> {
    void bulkInsert(List<PaymentDto> payments);

    BigDecimal sumByPayer(Long payer);
}
