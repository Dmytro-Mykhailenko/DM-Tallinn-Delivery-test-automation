package delivery.api;

import delivery.dto.OrderDto;
import delivery.utils.ApiClient;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    void deleteRandomOrderAndCheckResponse() {

        Response createResponse = ApiClient.createOrder(getAuthenticatedRequestSpecification(), OrderDto.createRandomOrder());

        Response deleteResponse = ApiClient.deleteOrderById(getAuthenticatedRequestSpecification(), createResponse.getBody().path("id"));

        Assertions.assertAll("Order creation",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, deleteResponse.getStatusCode(), "Status code is OK"),
                () -> Assertions.assertEquals("true", deleteResponse.asString(), "Response body contains \"true\"")
        );

    }
}