package lamph11.api.rest.dto;

import lamph11.api.service.dto.CategoryDTO;
import lombok.Data;

import java.util.List;

@Data
public class GetListCategoryResponse {

    private List<CategoryDTO> categories;
}
