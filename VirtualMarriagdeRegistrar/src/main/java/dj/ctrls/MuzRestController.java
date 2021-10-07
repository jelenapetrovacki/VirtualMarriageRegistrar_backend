package dj.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dj.jpa.Muz;
import dj.repository.MuzRepository;

@CrossOrigin
@RestController
public class MuzRestController {

	@Autowired
	private MuzRepository muzRepository;

	// insert
	@PostMapping("muz")
	public Muz insertMuz(@RequestBody Muz muz) {
		if (!muzRepository.existsById(muz.getId())) {

			Muz muzVracen = muzRepository.save(muz);

			return muzVracen;
		}
		return null;
	}
}
