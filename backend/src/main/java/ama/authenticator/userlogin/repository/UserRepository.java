package ama.authenticator.userlogin.repository;

import ama.authenticator.userlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
