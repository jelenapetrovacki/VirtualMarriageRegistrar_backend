package dj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dj.jpa.Zahtev;

public interface ZahtevRepository extends JpaRepository<Zahtev, Integer> {

}
