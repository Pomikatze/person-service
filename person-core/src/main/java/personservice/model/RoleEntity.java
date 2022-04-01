package personservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
public class RoleEntity implements GrantedAuthority {

    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
