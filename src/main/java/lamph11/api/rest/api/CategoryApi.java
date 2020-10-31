package lamph11.api.rest.api;

import lamph11.api.exception.BaseException;
import lamph11.api.rest.dto.CreateCategoryRequest;
import lamph11.api.rest.dto.UpdateCategoryRequest;
import lamph11.api.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryApi {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<?> getCategories(
            @RequestParam(required = false) Long parentId
    ) {
        return ResponseEntity.ok(categoryService.getListCategory(parentId));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @Valid @RequestBody CreateCategoryRequest request
    ) throws BaseException {
        return ResponseEntity.ok(categoryService.create(request));
    }


    @PostMapping("/update")
    public ResponseEntity<?> update(
            @Valid @RequestBody UpdateCategoryRequest request
    ) throws BaseException {
        return ResponseEntity.ok(categoryService.update(request));
    }
}
