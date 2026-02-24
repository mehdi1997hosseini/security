package ir.mehdihosseini.security.core.entity.audit;

import ir.mehdihosseini.security.core.entity.BasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


/**
 * -----------------------------------------------------------------------------
 * <p>English:</p>
 * BasicAuditableEntity extends BasicEntity and adds auditing capabilities
 * including createdBy, createdAt, updatedBy, updatedAt, deletedBy, and deletedAt.
 * It also includes versioning for optimistic locking.
 * <p>
 * Type Parameter:
 * - ID: The type of the primary key
 * <p>
 * Features:
 * - Tracks who created, updated, and deleted the entity
 * - Uses Hibernate annotations like @CreationTimestamp and @UpdateTimestamp
 * - Supports optimistic locking with @Version
 * <p>
 * -----------------------------------------------------------------------------
 * <p> فارسی:</p>
 * این کلاس از BasicEntity ارث‌بری می‌کند و قابلیت‌های مربوط به لاگ‌گیری و ممیزی (Auditing) را به آن اضافه می‌نماید؛
 * از جمله فیلدهای createdBy، createdAt، updatedBy، updatedAt، deletedBy، و deletedAt.
 * همچنین از نسخه‌بندی (versioning) برای پیاده‌سازی optimistic locking پشتیبانی می‌کند.
 * <p>
 * پارامتر نوعی:
 * - ID: نوع کلید اصلی موجودیت
 * <p>
 * قابلیت‌ها:
 * - ثبت اطلاعات مربوط به ایجاد، به‌روزرسانی و حذف داده‌ها
 * - استفاده از انوتیشن‌های Hibernate برای زمان‌بندی
 * - کنترل همزمانی با استفاده از فیلد version
 * <p>
 * -----------------------------------------------------------------------------
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BasicAuditEntity<ID> extends BasicEntity<ID> {

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @LastModifiedBy
    @Column(name = "update_by")
    private String updatedBy;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_by")
    private String deletedBy;
    @Column(name = "deleted_at")
    private Date deletedAt;
    @Version
    private Integer version = 1;

}
