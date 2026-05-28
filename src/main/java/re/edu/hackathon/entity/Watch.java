package re.edu.hackathon.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "watches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_name")
    private String modelName;

    private String brand;

    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type")
    private Movement movementType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "is_deleted")
    private boolean deleted;
}
