package delivery.api;

import com.google.gson.Gson;
import delivery.dto.OrderDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import delivery.utils.ApiClient;

public class OrderTest extends BaseSetupApi {

    @Test
    void getAllOrdersInformationAndCheckResponse() {

        Response response = ApiClient.getOrders(getAuthenticatedRequestSpecification());

        Assertions.assertAll("Getting list of all orders",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK"));

    }

    @Test
    void createOrderWithCorrectRandomDataAndCheckResponse() {

        Response response = ApiClient.createOrder(getAuthenticatedRequestSpecification(), OrderDto.createRandomOrder());

        Assertions.assertAll("Order creation",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK"),
                () -> Assertions.assertEquals("OPEN", response.path("status"), "New order status is OPEN"),
                () -> Assertions.assertNotEquals(0, (int) response.path("id"), "New order ID not equal 0")
        );

    }
}
