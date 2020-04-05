package house.greysap.shardpay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentDto {

    /**
     * An ID of a person, who sends the money
     */
    private Long payer;

    /**
     * An ID of a person, who receives the money
     */
    private Long payee;

    /**
     * Amount of money in cents
     */
    private Long amount;
}