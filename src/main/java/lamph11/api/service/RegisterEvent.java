package lamph11.api.service;

import lamph11.api.entity.Category;
import org.springframework.context.ApplicationEvent;

public class RegisterEvent extends ApplicationEvent {

    private Category category;

    public RegisterEvent(Category source) {
        super(source);
        this.category = source;
    }

    public Category getCategory() {
        return category;
    }
}
