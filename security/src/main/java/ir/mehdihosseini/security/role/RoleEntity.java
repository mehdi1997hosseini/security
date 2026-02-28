package ir.mehdihosseini.security.role;

import ir.mehdihosseini.security.core.entity.BasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TBL_ROLES")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity extends BasicEntity<String> {

    private String title;
    @Column(nullable = false , unique = true)
    private String roleName;

}
