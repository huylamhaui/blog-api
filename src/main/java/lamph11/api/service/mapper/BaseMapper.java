package lamph11.api.service.mapper;

import java.util.List;

public interface BaseMapper<Entity, DTO> {

    Entity toEntity(DTO dto);

    List<Entity> toEntity(List<DTO> dtoList);

    DTO toDTO(Entity entity);

    List<DTO> toDTO(List<Entity> entities);
}
