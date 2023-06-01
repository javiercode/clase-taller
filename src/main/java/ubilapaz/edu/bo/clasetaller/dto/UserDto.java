package ubilapaz.edu.bo.clasetaller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
public class UserDto {
    public String username;
    public String nombre;
    public String password;

    public UserDto(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }
}
