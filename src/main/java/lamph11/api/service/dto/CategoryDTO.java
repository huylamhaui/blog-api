package lamph11.api.service.dto;

import lombok.Data;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private String description;
    private Integer level;
    private Integer totalChildren;
    private Long parentId;
}
