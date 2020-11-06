package lamph11.api.service;

import lamph11.api.entity.Category;
import lamph11.api.exception.BaseException;
import lamph11.api.repository.CategoryRepository;
import lamph11.api.rest.dto.*;
import lamph11.api.service.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public Category findById(Long id) throws BaseException {
        Optional<Category> optional = categoryRepository.findById(id);
        if (!optional.isPresent())
            throw new BaseException("id not found");
        return optional.get();
    }

    @Transactional(readOnly = true)
    public GetListCategoryResponse getListCategory(Long parentId) {
        List<Category> categories = categoryRepository.findAllByParent_Id(parentId);

        GetListCategoryResponse response = new GetListCategoryResponse();
        response.setCategories(categoryMapper.toDTO(categories));
        return response;
    }


    public CreateCategoryResponse create(CreateCategoryRequest request) throws BaseException {
        Long parentId = request.getParentId();
        Category parent = null;
        if (Objects.nonNull(parentId))
            parent = findById(request.getParentId());

        Category category = new Category()
                .setName(request.getName())
                .setDescription(request.getDescription())
                .setParent(parent);
        categoryRepository.save(category);

        CreateCategoryResponse response = new CreateCategoryResponse();
        response.setCategoryDTO(categoryMapper.toDTO(category));
        return response;
    }


    public UpdateCategoryResponse update(UpdateCategoryRequest request) throws BaseException {
        Optional<Category> optional = categoryRepository.findById(request.getId());
        if (!optional.isPresent())
            throw new BaseException("id not found");
        Category category = findById(request.getId())
                .setName(request.getName())
                .setDescription(request.getDescription())
                .setParent(findById(request.getParentId()));
        categoryRepository.save(category);

        UpdateCategoryResponse response = new UpdateCategoryResponse();
        response.setCategory(categoryMapper.toDTO(category));
        return response;
    }

}
