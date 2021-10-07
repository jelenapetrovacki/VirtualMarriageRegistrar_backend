package dj.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dj.jpa.Zahtev;
import dj.repository.ZahtevRepository;

@CrossOrigin
@RestController
public class ZahtevRestController {

	@Autowired
	private ZahtevRepository zahtevRepository;

	// insert
	@PostMapping("zahtev")
	public Zahtev insertZahtev(@RequestBody Zahtev zahtev) {
		if (!zahtevRepository.existsById(zahtev.getId())) {

			Zahtev zahtevVracen = zahtevRepository.save(zahtev);

			return zahtevVracen;
		}
		return null;
	}
}
