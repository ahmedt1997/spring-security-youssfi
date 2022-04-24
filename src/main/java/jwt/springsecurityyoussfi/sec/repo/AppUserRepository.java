package jwt.springsecurityyoussfi.sec.repo;

import jwt.springsecurityyoussfi.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
