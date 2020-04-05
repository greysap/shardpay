package house.greysap.shardpay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisbursementDto {

    /**
     * An ID of a person, who sends the money
     */
    private Long payer;

    /**
     * The sum of payer's payments
     */
    private BigDecimal totalAmount;
}
