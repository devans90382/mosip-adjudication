package io.mosip.adjudication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mosip.adjudication.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	Admin findAdminByUsername(String username);
}
