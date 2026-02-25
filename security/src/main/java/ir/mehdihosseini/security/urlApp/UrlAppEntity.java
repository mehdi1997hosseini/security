package ir.mehdihosseini.security.urlApp;

import ir.mehdihosseini.security.core.entity.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "TBL_URLS_APP")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UrlAppEntity extends BasicEntity<String> {

    private boolean permitAll = false;
    private String title;
    private String endpoint;
    private String contextPath;

}
