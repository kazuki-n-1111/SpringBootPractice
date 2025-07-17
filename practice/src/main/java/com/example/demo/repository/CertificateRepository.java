package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Admins;

public interface CertificateRepository extends JpaRepository<Admins, Long> {

	boolean existsByEmail(String email);

	// spring securityのログイン処理時に該当レコードを持ってくる処理
	Optional<Admins> findByEmail(String username);
}
