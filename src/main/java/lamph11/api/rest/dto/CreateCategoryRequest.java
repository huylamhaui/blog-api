package lamph11.api.rest.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateCategoryRequest {

    @NotBlank
    @Size(max = 80)
    private String name;
    @Size(max = 250)
    private String description;
    @Range(min = 1)
    private Long parentId;
}
