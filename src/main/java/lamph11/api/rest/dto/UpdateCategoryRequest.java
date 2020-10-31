package lamph11.api.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateCategoryRequest {

    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @Size(max = 250)
    private String description;
    private Long parentId;
}
