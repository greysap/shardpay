package house.greysap.shardpay.service;


import house.greysap.shardpay.dto.PaymentDto;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentService {
    void saveAll(List<PaymentDto> paymentDtos);

    BigDecimal getTotalAmount(Long payer);
}
