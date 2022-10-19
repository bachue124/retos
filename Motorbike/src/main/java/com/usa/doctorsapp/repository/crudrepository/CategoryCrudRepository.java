package com.usa.doctorsapp.repository.crudrepository;

import com.usa.doctorsapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
