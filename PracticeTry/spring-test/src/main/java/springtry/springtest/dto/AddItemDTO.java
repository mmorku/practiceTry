package springtry.springtest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddItemDTO {
    private Long id;
    private String name;
    private String manufacturer;
    private String model;
    private String manufacturedDate;
    private int weight;
    private int price;
    private int availability;
}
