
package ua.sasa.domain.security;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author sasav
 */
@Entity
@Table(name = "Authorities")
public class Authority implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    
    @ManyToMany
    private List<User> users = new LinkedList<User>();
    
    private String authority;

    public Authority() {
    }

    public Authority(long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
}
