package io.mosip.adjudication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.mosip.adjudication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
