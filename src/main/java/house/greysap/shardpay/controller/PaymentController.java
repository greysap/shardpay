package house.greysap.shardpay.controller;

import house.greysap.shardpay.dto.DisbursementDto;
import house.greysap.shardpay.dto.PaymentDto;
import house.greysap.shardpay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/payments", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void savePayments(@RequestBody List<PaymentDto> paymentDtos) {
        paymentService.saveAll(paymentDtos);
    }

    @RequestMapping(value = "/totalAmount/{payer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public DisbursementDto getTotalAmount(@PathVariable Long payer) {
        return new DisbursementDto(payer, paymentService.getTotalAmount(payer));
    }
}
