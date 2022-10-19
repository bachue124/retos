package com.usa.doctorsapp.repository;

import com.usa.doctorsapp.model.Category;
import com.usa.doctorsapp.repository.crudrepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getById(Integer idCategory){
        return categoryCrudRepository.findById(idCategory);
        }

    public Category save(Category category) {
        return categoryCrudRepository.save(category);
    }

    public void delete(Category category){
        categoryCrudRepository.delete(category);
    }
}
