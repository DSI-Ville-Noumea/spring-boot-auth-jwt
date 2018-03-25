package io.github.mbarre.springbootauthjwt.repository;

import io.github.mbarre.springbootauthjwt.domain.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
	ApplicationUser findByUsername(String username);
}
