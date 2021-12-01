package prvi.projekat.pokusaj1.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prvi.projekat.pokusaj1.app.model.Porudzbina;

@Repository
public interface Repozitorijum extends JpaRepository<Porudzbina, Long>
{
   /* @Transactional
    @Modifying
    void deletebynotdone(Boolean uradjen);*/
}
