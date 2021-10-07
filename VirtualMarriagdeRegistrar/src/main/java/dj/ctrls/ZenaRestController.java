package dj.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dj.jpa.Zena;
import dj.repository.ZenaRepository;

@CrossOrigin
@RestController
public class ZenaRestController {

	@Autowired
	private ZenaRepository zenarepository;

	// insert
	@PostMapping("zena")
	public Zena insertZena(@RequestBody Zena zena) {
		if (!zenarepository.existsById(zena.getId())) {

			Zena zenaVracena = zenarepository.save(zena);

			return zenaVracena;
		}
		return null;
	}
}
