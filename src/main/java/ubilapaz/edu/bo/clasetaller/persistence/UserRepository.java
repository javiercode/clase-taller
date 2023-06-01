package ubilapaz.edu.bo.clasetaller.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubilapaz.edu.bo.clasetaller.domain.User;
import ubilapaz.edu.bo.clasetaller.dto.UserDto;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    //@Query(value = "select new ubilapaz.edu.bo.clasetaller.dto.UserDto(u.username,u.nombre,u.password) from user u order by u.nombre")
    //List<UserDto> usuarioList();

    //@Query(value = "SELECT new ubilapaz.edu.bo.clasetaller.dto.UserDto(r.username, r.password, r.nombre) FROM User r order by id desc")
//    @Query(value = "SELECT new UserDto(r.username, r.password, r.nombre) FROM user r order by id desc",nativeQuery = true)
    //List<UserDto> obtenerLista();

    @Query(value = "SELECT new ubilapaz.edu.bo.clasetaller.dto.UserDto(r.username, r.password, r.nombre) FROM User r order by id desc")
    List<UserDto> obtenerLista();

}
