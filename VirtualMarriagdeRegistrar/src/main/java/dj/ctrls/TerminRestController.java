package dj.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dj.jpa.Termin;
import dj.repository.TerminRepository;

@CrossOrigin
@RestController
public class TerminRestController {

	@Autowired
	private TerminRepository terminRepository;

	// insert
	@PostMapping("termin")
	public Termin insertTermin(@RequestBody Termin termin) {
		if (!terminRepository.existsById(termin.getId())) {

			Termin terminVracen = terminRepository.save(termin);

			return terminVracen;
		}
		return null;
	}
	
	@PutMapping("termin")
	public Termin updateTermin(@RequestBody Termin termin) {
		if (terminRepository.existsById(termin.getId())) {

			Termin terminVracen = terminRepository.save(termin);

			return terminVracen;
		}
		return null;
	}
}
