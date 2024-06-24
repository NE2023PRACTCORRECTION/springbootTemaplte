package com.rca.mireilleumutoni.template.v1.serviceImpls;


import com.rca.mireilleumutoni.template.v1.dto.requests.LaptopDTO;
import com.rca.mireilleumutoni.template.v1.exceptions.NotFoundException;
import com.rca.mireilleumutoni.template.v1.models.Laptop;
import com.rca.mireilleumutoni.template.v1.models.Student;
import com.rca.mireilleumutoni.template.v1.repositories.LaptopRepository;
import com.rca.mireilleumutoni.template.v1.repositories.StudentRepository;
import com.rca.mireilleumutoni.template.v1.services.LaptopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;
    private final StudentRepository studentRepository;
    @Override
    public List<Laptop> getAllLaptops() {
        try {
            return laptopRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Laptop getLaptopById(UUID id) {
        try {
            return laptopRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public Laptop createLaptop(LaptopDTO laptop) {
        try {
            Student student =  studentRepository.findById(laptop.getStudentId()).orElseThrow(
                    () -> new NotFoundException("The student with the given id was not found")
            );
            Laptop laptopEntity = new Laptop();
            laptopEntity.setBrand(laptop.getBrand());
            laptopEntity.setSerialNumber(laptop.getSerialNumber());
            laptopEntity.setStudent(student);
            return laptopRepository.save(laptopEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
