package me.thedivazo.simpleadminpanel.controller;

import me.thedivazo.simpleadminpanel.entity.PersonEntity;
import me.thedivazo.simpleadminpanel.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author TheDiVaZo
 * created on 18.01.2024
 */
@RestController
@RequestMapping("/person")
public class UserController {

    @Autowired
    private PersonService personService;

    @PostMapping("/reg")
    public ResponseEntity regPerson(@RequestBody PersonEntity personEntity) {
        try {
            personService.regPerson(personEntity);
            return ResponseEntity.ok("Пользователь добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity getPerson(@RequestParam long id) {
        try {
            return ResponseEntity.ok(personService.getPerson(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
