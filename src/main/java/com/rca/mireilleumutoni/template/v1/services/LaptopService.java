package com.rca.mireilleumutoni.template.v1.services;



import com.rca.mireilleumutoni.template.v1.dto.requests.LaptopDTO;
import com.rca.mireilleumutoni.template.v1.models.Laptop;

import java.util.List;
import java.util.UUID;

public interface LaptopService {
    List<Laptop> getAllLaptops();
    Laptop getLaptopById(UUID id);
    Laptop createLaptop(LaptopDTO laptop);
}

