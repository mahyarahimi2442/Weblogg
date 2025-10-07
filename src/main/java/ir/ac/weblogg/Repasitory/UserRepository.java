package ir.ac.weblogg.Repasitory;

import ir.ac.weblogg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername (String username);
}
