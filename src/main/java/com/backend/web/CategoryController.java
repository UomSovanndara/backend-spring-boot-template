package com.backend.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dao.CategoryDao;
import com.backend.domain.Category;

@RestController
@RequestMapping("catagories")
public class CategoryController {

    @Autowired
    private CategoryDao dao;

    @RequestMapping(value = "v1", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Category> create(HttpServletRequest request, @RequestBody Category body) {
        dao.add(body);
        return new ResponseEntity<Category>(body, HttpStatus.OK);
    }

    @RequestMapping(value = "v1/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> findById(HttpServletRequest request, @PathVariable Long id) {
        return new ResponseEntity<Category>(dao.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "v1/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Category> update(HttpServletRequest request, @PathVariable Long id, @RequestBody Category body) {
        Category domain = dao.findById(id);
        if (domain == null) {
            // throw
        }
        domain.setName(body.getName());
        domain.setState(body.getState());
        // TODO : update properties
        dao.update(domain);
        return new ResponseEntity<Category>(domain, HttpStatus.OK);
    }
}
