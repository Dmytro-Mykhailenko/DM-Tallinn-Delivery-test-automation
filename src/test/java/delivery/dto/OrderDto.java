package delivery.dto;

import delivery.utils.RandomDataGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OrderDto {

    private String status;
    private int courierId;
    private String customerName;
    private String customerPhone;
    private String comment;
    private int id;

    public OrderDto() {
    }

    public static OrderDto createRandomOrder() {

        return OrderDto.builder()
                .status("OPEN")
                .courierId(0)
                .customerName(RandomDataGenerator.generateName())
                .customerPhone(RandomDataGenerator.generatePhone())
                .comment(RandomDataGenerator.generateComment())
                .id(0)
                .build();

    }
}