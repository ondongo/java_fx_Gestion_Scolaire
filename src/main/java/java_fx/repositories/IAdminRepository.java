package java_fx.repositories;

import java_fx.entities.UsersAdmin;

public interface IAdminRepository {
    public UsersAdmin  findUserByLoginAndPassword(String login,String password);
    
}
