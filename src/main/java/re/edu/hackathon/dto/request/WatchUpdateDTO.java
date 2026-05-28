package re.edu.hackathon.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import re.edu.hackathon.entity.Movement;
import re.edu.hackathon.entity.Status;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WatchUpdateDTO {
    @NotBlank(message = "model_name khong duoc de trong")
    private String model_name;

    @NotBlank(message = "brand khong duoc de trong")
    private String brand;

    @Positive
    private Double price;

    private Movement movement_type;

    private Status status;
}
