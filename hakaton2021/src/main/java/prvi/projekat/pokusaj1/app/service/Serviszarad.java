package prvi.projekat.pokusaj1.app.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prvi.projekat.pokusaj1.app.exceptions.Nije_Nadjen;
import prvi.projekat.pokusaj1.app.model.Porudzbina;
import prvi.projekat.pokusaj1.app.repository.Repozitorijum;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Serviszarad
{
    private final Repozitorijum repo;

    public List<Porudzbina> getallporudzbine()
    {
        return repo.findAll();
    }

    public Porudzbina getbyid(Long id)
    {
        Optional<Porudzbina> optionalajtem =repo.findById(id);

        if(optionalajtem.isPresent())
        {
            return optionalajtem.get();
        }
        else
        {
            throw new Nije_Nadjen("Nema trazenog id-a.");
        }

    }

    public Porudzbina createnewporudzbina(Porudzbina ajtem)
    {
        return repo.save(ajtem);
    }

    public Porudzbina updateporudzbina(Long id, Porudzbina ajtem)
    {
        Optional<Porudzbina> optionalajtem =repo.findById(id);

        if(optionalajtem.isPresent())
        {
            Porudzbina sacuvan = optionalajtem.get();

            sacuvan.setIme(ajtem.getIme());
            sacuvan.setEmail(ajtem.getEmail());
            sacuvan.setStatus(ajtem.getStatus());
            sacuvan.setTip(ajtem.getTip());

            return repo.save(sacuvan);
        }
        else
        {
            throw new Nije_Nadjen("Nema trazenog id-a.");
        }
    }
    public Porudzbina markasisporucena(Long id)
    {
        Optional<Porudzbina> optionalajtem =repo.findById(id);

        if(optionalajtem.isPresent())
        {
            Porudzbina sacuvan = optionalajtem.get();

            sacuvan.setStatus(true);

            return repo.save(sacuvan);
        }
        else
        {
            throw new Nije_Nadjen("Nema trazenog id-a.");
        }
    }

    public Porudzbina markaspredata(Long id)
    {
        Optional<Porudzbina> optionalajtem =repo.findById(id);

        if(optionalajtem.isPresent())
        {
            Porudzbina sacuvan = optionalajtem.get();

            sacuvan.setStatus(false);

            return repo.save(sacuvan);
        }
        else
        {
            throw new Nije_Nadjen("Nema trazenog id-a.");
        }
    }

    public Porudzbina deletebyid(Long id)
    {
        Optional<Porudzbina> optionalajtem =repo.findById(id);

        if(optionalajtem.isPresent())
        {
            repo.deleteById(id);
            return null;
        }
        else
        {
            throw new Nije_Nadjen("Nema trazenog id-a.");
        }
    }

   /* public Porudzbina createnewkorisnik(Porudzbina ajtem)
    {
        return repo.save(ajtem);
    }*/
/*
    public void deletebynotdone()
    {
        repo.deletebynotdone(false);
    }
*/
}
