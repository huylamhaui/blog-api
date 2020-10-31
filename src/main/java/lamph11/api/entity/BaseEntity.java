package lamph11.api.entity;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity implements Serializable {

    protected LocalDateTime createdDate;
    protected String createdBy;
    protected LocalDateTime updatedDate;
    protected String updatedBy;

    @PrePersist
    protected void beforeCreate() {
        createdDate = LocalDateTime.now();
        createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PreUpdate
    protected void beforeUpdate() {
        updatedDate = LocalDateTime.now();
        updatedBy = SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
