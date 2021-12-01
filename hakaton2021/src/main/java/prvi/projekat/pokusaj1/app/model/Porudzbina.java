package prvi.projekat.pokusaj1.app.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity

public class Porudzbina
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @Column(unique=true, nullable = false)
    private String ime;
    private String email;
    private String poruka;
    @CreationTimestamp
    private Instant datum_kreiranja;
    private Boolean status;
    private Tip_obroka tip;

}
