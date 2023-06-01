package ubilapaz.edu.bo.clasetaller.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.clasetaller.dto.UsuarioDto;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/obtener")
    public ResponseEntity<UsuarioDto> test(){
        String nombre="";
        UsuarioDto usuarioDto = new UsuarioDto("JCL","123456",30);
        return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
    }
    @PostMapping("/registrar")
    public ResponseEntity<String> test2(@RequestBody UsuarioDto usuarioDto){
        //logica para registrar en la tabla usuario
        return new ResponseEntity<String>("Hola "+usuarioDto.usuario+" tu password es: "+usuarioDto.password,
                HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Integer> testPut(@PathVariable int id){

        return new ResponseEntity<Integer>(id*2, HttpStatus.OK);
    }
}
