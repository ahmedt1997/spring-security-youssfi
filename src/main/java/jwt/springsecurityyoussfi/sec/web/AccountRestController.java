package jwt.springsecurityyoussfi.sec.web;

import jwt.springsecurityyoussfi.sec.entities.AppRole;
import jwt.springsecurityyoussfi.sec.entities.AppUser;
import jwt.springsecurityyoussfi.sec.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService ;

//    Afficher ga3 les utilisateurs
    @GetMapping(path = "/users")
    public List<AppUser> appUsers(){
        return  accountService.listUsers();
    }
//    Ajouter un utilisateurs
    @PostMapping(path = "/users")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }
// Ajouter un role
    @PostMapping(path = "/roles")
    public AppRole saveRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }
// Ajouter un role a un utilisateur
    @PostMapping(path = "/AddRoleToUser")
public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());
//        return "the role was added successfully to "+roleUserForm.getUsername();
}

}
@Data
class RoleUserForm{
    private String username ;
    private String roleName;
}
