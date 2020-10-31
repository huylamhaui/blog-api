package lamph11.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "blog_category")
@Data
@Accessors(chain = true)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @Size(max = 80)
    private String name;
    @Size(max = 250)
    private String description;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;
}
