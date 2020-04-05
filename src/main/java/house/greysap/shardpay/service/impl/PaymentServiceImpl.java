package house.greysap.shardpay.service.impl;


import house.greysap.shardpay.dto.PaymentDto;
import house.greysap.shardpay.repository.impl.PaymentRepositoryImpl;
import house.greysap.shardpay.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepositoryImpl paymentRepository;

    @Override
    public void saveAll(List<PaymentDto> paymentDtos) {
        paymentRepository.bulkInsert(paymentDtos); //FIXME
    }

    @Override
    public BigDecimal getTotalAmount(Long payer) {
        return paymentRepository.sumByPayer(payer);
    }
}
