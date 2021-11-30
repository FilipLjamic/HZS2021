package prvi.projekat.pokusaj1.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class korisnik
{
    private String ime;
    private String prezime;
    private String email;
}
