package com.chandru.ebookstore.controller;

import com.chandru.ebookstore.entity.Category;
import com.chandru.ebookstore.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return repository.save(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return repository.findAll();
    }
}