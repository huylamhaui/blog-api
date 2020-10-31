package lamph11.api.rest.dto;

import lamph11.api.service.dto.CategoryDTO;
import lombok.Data;

@Data
public class UpdateCategoryResponse {

    private CategoryDTO category;
}
