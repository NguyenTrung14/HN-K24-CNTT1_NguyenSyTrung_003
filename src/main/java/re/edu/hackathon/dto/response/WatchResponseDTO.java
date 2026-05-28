package re.edu.hackathon.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import re.edu.hackathon.entity.Movement;
import re.edu.hackathon.entity.Status;
import re.edu.hackathon.entity.Watch;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class WatchResponseDTO {
    private Long id;

    @JsonProperty("model_name")
    private String modelName;

    private String brand;

    private Double price;

    @JsonProperty("movement_type")
    private Movement movementType;

    private Status status;

    @JsonProperty("is_deleted")
    private boolean deleted;

    public static WatchResponseDTO fromEntity(Watch watch) {
        return WatchResponseDTO.builder()
                .id(watch.getId())
                .modelName(watch.getModelName())
                .brand(watch.getBrand())
                .price(watch.getPrice())
                .movementType(watch.getMovementType())
                .status(watch.getStatus())
                .deleted(watch.isDeleted())
                .build();
    }
}
