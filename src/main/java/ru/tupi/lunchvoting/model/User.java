package ru.tupi.lunchvoting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.tupi.lunchvoting.HasIdAndEmail;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true, exclude = {"password", "votes"})
public class User extends NamedEntity implements HasIdAndEmail {

    public User(Integer id, String name, String email, String password, Set<Role> roles, List<Vote> votes) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.votes = votes;
    }

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = STRING_MAX_SIZE)
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 6, max = 256)
    @NotNull
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date registered = new Date();

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "u_roles_user_role")})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private List<Vote> votes;

    public boolean hasRole(Role role) {
        return roles != null && roles.contains(role);
    }
}