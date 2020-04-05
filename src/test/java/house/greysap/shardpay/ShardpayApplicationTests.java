package house.greysap.shardpay;

import com.fasterxml.jackson.databind.ObjectMapper;
import house.greysap.shardpay.dto.DisbursementDto;
import house.greysap.shardpay.dto.PaymentDto;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Set;

class ShardpayApplicationTests {

	private final HttpClient httpClient = HttpClient.newBuilder()
			.version(HttpClient.Version.HTTP_2)
			.build();

	@Test
	void post100AndGet10() throws IOException, InterruptedException {
		// Prepare and send 10 POST-requests with 10 elements each.
		Set<PaymentDto> paymentDtoSet = new HashSet<>();
		for (long i = 0; i < 10L; i++) {
			 paymentDtoSet.add(new PaymentDto(i, 42L, 1L));
		}

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(paymentDtoSet);

		for (int i = 0; i < 10; i++) {
			HttpRequest sendPayments = HttpRequest.newBuilder()
					.POST(HttpRequest.BodyPublishers.ofString(jsonString))
					.header("Content-Type", "application/json")
					.uri(URI.create("http://localhost:8080/payments"))
					.build();

			HttpResponse<String> response = httpClient.send(sendPayments, HttpResponse.BodyHandlers.ofString());
			assertThat(response.statusCode(), is(200));
		}

		// Send 10 GET-requests
		for (int i = 0; i < 10; i++) {
			HttpRequest getTotalAmount = HttpRequest.newBuilder()
					.GET()
					.header("Content-Type", "application/json")
					.uri(URI.create("http://localhost:8080/totalAmount/" + i))
					.build();

			HttpResponse<String> response = httpClient.send(getTotalAmount, HttpResponse.BodyHandlers.ofString());

			assertThat(response.statusCode(), is(200));
			DisbursementDto disbursement = objectMapper.readValue(response.body(), DisbursementDto.class);

			assertThat(disbursement.getTotalAmount(), is(BigDecimal.TEN));
		}

	}
}
