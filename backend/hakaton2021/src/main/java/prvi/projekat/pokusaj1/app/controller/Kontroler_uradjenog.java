package prvi.projekat.pokusaj1.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import prvi.projekat.pokusaj1.app.exceptions.Nije_Nadjen;
import prvi.projekat.pokusaj1.app.model.Tip_uradjenog;
import prvi.projekat.pokusaj1.app.model.Uraditi;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/uraditi")
public class Kontroler_uradjenog
{
    private List<Uraditi> ajtem= new ArrayList<>();

    @GetMapping

    List<Uraditi> getajtems()
    {
        /*ajtem.add(Uraditi.builder().id(1L).naslov("Privremeni1").build());
        ajtem.add(Uraditi.builder().id(2L).naslov("Privremeni2").build());
        ajtem.add(Uraditi.builder().id(3L).naslov("Privremeni3").build());*/

        return ajtem;
    }

    @GetMapping("/{id}")

    Uraditi getajtemid(@PathVariable Long id)
    {
        Uraditi pomocni=nadjipoid(id);
        if(pomocni!=null)
        {
            return pomocni;
        }
        throw new Nije_Nadjen("Nema trazenog id-a.");
    }

    @GetMapping("/naslov-pretaga")

    Uraditi getajtemnaslov(@RequestParam String naslov)
    {
        for (int i=0;i< ajtem.size();i++)
        {
            if(ajtem.get(i).getNaslov().equals(naslov))
            {
                return ajtem.get(i);
            }
        }
        throw new Nije_Nadjen("Nema trazenog naslova.");
    }

    @PostMapping

    Uraditi napraviajtem(@RequestBody Uraditi nekiajtem)
    {
        if(ajtem.isEmpty())
        {
            nekiajtem.setId(1L);
            ajtem.add(nekiajtem);
            return nekiajtem;
        }
        else                
        {
            nekiajtem.setId(ajtem.get(ajtem.size()-1).getId()+1);
            ajtem.add(nekiajtem);
            return nekiajtem;
        }

    }


    private Uraditi nadjipoid(Long id)
    {
        for (int i=0;i< ajtem.size();i++)
        {
            if(ajtem.get(i).getId()==id)
            {
                return ajtem.get(i);
            }
        }
        return null;
    }


}
