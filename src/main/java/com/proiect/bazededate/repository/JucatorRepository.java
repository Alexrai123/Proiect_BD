package com.proiect.bazededate.repository;

import com.proiect.bazededate.models.Jucator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface JucatorRepository extends JpaRepository<Jucator, UUID> {
}
