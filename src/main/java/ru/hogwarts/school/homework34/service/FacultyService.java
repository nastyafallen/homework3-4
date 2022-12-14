package ru.hogwarts.school.homework34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.homework34.model.Faculty;
import ru.hogwarts.school.homework34.repository.FacultyRepository;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> getFaculty(long id) {
        return facultyRepository.findById(id);
    }

    public Faculty updateFaculty(long id, Faculty faculty) {
        Optional<Faculty> optional = facultyRepository.findById(id);
        if (optional.isPresent()) {
            Faculty facultyFromDb = optional.get();
            facultyFromDb.setColor(faculty.getColor());
            facultyFromDb.setName(faculty.getName());
            return facultyRepository.save(facultyFromDb);
        } else {
            return null;
        }
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public List<Faculty> getFacultiesByColor(String color) {
        return facultyRepository.getFacultiesByColor(color);
    }

}
