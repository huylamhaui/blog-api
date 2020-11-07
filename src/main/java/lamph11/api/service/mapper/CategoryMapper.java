package lamph11.api.service.mapper;

import lamph11.api.entity.Category;
import lamph11.api.service.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO> {

    @Mapping(source = "parent.id", target = "parentId")
    @Override
    CategoryDTO toDTO(Category category);
}
