package prvi.projekat.pokusaj1.app.controller;


import org.springframework.web.bind.annotation.*;
import prvi.projekat.pokusaj1.app.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")

public class klasazatest
{
    @GetMapping
    String test()
    {
        return "Vracam nazad test";
    }

    @GetMapping("/korisnik")
    List<User> NoviUser() {
        User korinsik = User.builder()
                .name("Dusan")
                .surname("Silni")
                .email("dusan.silni@prvabeogim.edu.rs")
                .build();
        List<User> korisnici = new ArrayList<>();
        korisnici.add(korinsik);
        korisnici.add(korinsik);
        korisnici.add(korinsik);

        return korisnici;
    }

    @PostMapping("/korisnik")
    User NoviUserPost(@RequestBody User korisnik)
    {
        return korisnik;
    }
}
