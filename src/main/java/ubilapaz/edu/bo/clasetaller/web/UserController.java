package ubilapaz.edu.bo.clasetaller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.clasetaller.domain.User;
import ubilapaz.edu.bo.clasetaller.dto.UserDto;
import ubilapaz.edu.bo.clasetaller.persistence.UserRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<String> registrar(@RequestBody UserDto userDto){
        String mensaje = "Registro exitoso";
        try{
            User user= new User();
            user.setNombre(userDto.nombre);
            user.setUsername(userDto.username);
            user.setPassword(userDto.password);
            user.setFechaRegistro(LocalDateTime.now());
            //registrar el objeto
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e);
            mensaje = "Algo salio mal";
        }


        //userRepository.findAll();
        return new ResponseEntity<String>(mensaje, HttpStatus.OK);
    }


    @GetMapping("/reporte")
    public ResponseEntity<List<UserDto>> reporte(){
        List<UserDto> userList =  userRepository.obtenerLista();
        return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
    }
}
