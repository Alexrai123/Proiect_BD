package com.proiect.bazededate.repository;

import com.proiect.bazededate.models.Meci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MeciRepository extends JpaRepository<Meci, UUID> {
}
