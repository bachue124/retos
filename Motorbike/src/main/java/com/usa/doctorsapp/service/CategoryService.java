package com.usa.doctorsapp.service;

import com.usa.doctorsapp.model.Category;
import com.usa.doctorsapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getById(Integer id){
        return categoryRepository.getById(id);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        } else {
            Optional<Category> optionalCategory= categoryRepository.getById(category.getId());
            if(optionalCategory.isEmpty()){
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> optionalSpecialty= categoryRepository.getById(category.getId());
            if(!optionalSpecialty.isEmpty()){
                if(category.getName()!=null){
                    optionalSpecialty.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    optionalSpecialty.get().setDescription(category.getDescription());
                }
                categoryRepository.save(optionalSpecialty.get());
                return optionalSpecialty.get();
            } else {
                return category;
            }
        } else {
            return category;
        }
    }

    public boolean delete(Integer id){
        Boolean aBoolean=getById(id).map(specialty -> {
            categoryRepository.delete(specialty);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
