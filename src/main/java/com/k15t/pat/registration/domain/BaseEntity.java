package com.k15t.pat.registration.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Parviz on 28.04.2018.
 */
@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", updatable = false, nullable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Version
    private long version;

    //Would work if spring security is used
    @Column(name = "created_by", updatable = false, length = 128)
    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    @Column(name = "modified_by", length = 128)
    private String modifiedBy;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }
}
