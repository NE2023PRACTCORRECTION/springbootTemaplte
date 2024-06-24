package com.rca.mireilleumutoni.template.v1.repositories;


import com.rca.mireilleumutoni.template.v1.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, UUID> {
}

