package prvi.projekat.pokusaj1.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import prvi.projekat.pokusaj1.app.model.Porudzbina;
import prvi.projekat.pokusaj1.app.service.Serviszarad;

import java.util.List;

@RestController
@RequestMapping("/porudzbina")
@RequiredArgsConstructor
public class Kontroler_uradjenog
{
    private final Serviszarad ajtemservis;

    @GetMapping
    List<Porudzbina> getalluraditi()
    {
        return ajtemservis.getallporudzbine();
    }

    @GetMapping("/{id}")
    Porudzbina getajtemid(@PathVariable Long id)
    {
        return ajtemservis.getbyid(id);
    }

    /*@GetMapping("/naslov-pretaga")

    Uraditi getajtemnaslov(@RequestParam String naslov)
    {
        return ajtemservis.getbynaslov();
    }*/

    @PostMapping
    Porudzbina napraviporudzbinu(@RequestBody Porudzbina nekiajtem)
    {
        return ajtemservis.createnewporudzbina(nekiajtem);
    }

    @PutMapping("/{id}")
    Porudzbina updateajtemid(@PathVariable Long id, @RequestBody Porudzbina updateovanajtem)
    {
        return ajtemservis.updateporudzbina(id, updateovanajtem);
    }

    @PutMapping("/{id}/uradjen")
    Porudzbina isporucena(@PathVariable Long id)
    {
        return ajtemservis.markasisporucena(id);
    }

    @PutMapping("/{id}/neuradjen")
    Porudzbina predata(@PathVariable Long id)
    {
        return ajtemservis.markaspredata(id);
    }

    @DeleteMapping("/{id}")

    void deleteajtemid(@PathVariable Long id)
    {
        ajtemservis.deletebyid(id);
    }

    /*@PostMapping
    Porudzbina napisiporuku(@RequestBody Porudzbina korisnik)
    {
        return ajtemservis.createnewporudzbina(korisnik);
    }*/

   /* @DeleteMapping

    void deleteajtemnaslov(@RequestParam String naslov)
    {
        int indexzabrisanje=nadjiindexponaslovu(naslov);

        if(indexzabrisanje!=-1)
        {
            ajtem.remove(indexzabrisanje);
        }
        else
        {
            throw new Nije_Nadjen("Nema trazenog naslova.");
        }
    }*/

  /*  @DeleteMapping("/uradjen")

    void deleteneuradjen()
    {
        ajtemservis.deletebynotdone();
    }*/

/*
    private int nadjiindexpoid(Long id)
    {
        for (int i=0;i< ajtem.size();i++)
        {
            if(ajtem.get(i).getId()==id)
            {
                return i;
            }
        }
        return -1;
    }

    private int nadjiindexponaslovu(String naslov)
    {
        for (int i=0;i< ajtem.size();i++)
        {
            if(ajtem.get(i).getNaslov().equals(naslov))
            {
                return i;
            }
        }
        return -1;
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
*/

}
