package ir.mehdihosseini.security.permission;

import ir.mehdihosseini.security.core.entity.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "TBL_USER_PERMISSION")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserPromissionEntity extends BasicEntity<String> {

    private String permissionName;
    
}
