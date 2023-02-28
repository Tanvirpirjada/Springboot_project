package com.example.Student_management_System.Controller;


import com.example.Student_management_System.Dao.IBookrepository;
import com.example.Student_management_System.Dao.IStudentrepository;
import com.example.Student_management_System.Model.Book;
import com.example.Student_management_System.Model.Student;
import com.example.Student_management_System.Service.Bookservice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Bookcontroller {

    @Autowired
    Bookservice bookservice;

    @Autowired
    IBookrepository bookrepository;
    @Autowired
    IStudentrepository studentrepository;

    @PostMapping("savebook")
    public ResponseEntity savebooks(@RequestBody String books){
        JSONObject jsonObject=new JSONObject(books);
        Book book=setbook(jsonObject);
        bookservice.savebook(book);
        return  new ResponseEntity("books saved", HttpStatus.CREATED);
    }

    private Book setbook(JSONObject json) {
        Book book=new Book();

        book.setTitle(json.getString("title"));
        book.setAuthor(json.getString("author"));
        book.setDescription(json.getString("description"));
        book.setPrice(json.getString("price"));

        Integer student_id= json.getInt("student_id");
        Student student=studentrepository.findById(student_id).get();

        book.setStudent(student);
         return  book;
    }

    @GetMapping("getbooks")
    public List<Book> getbooks (@Nullable @RequestParam Integer book_id){
        List<Book> books=bookservice.getbooks(book_id);
        return books;
    }

    @PutMapping("updatebook/{book_id}")
    public String updatebook(@PathVariable Integer book_id, @RequestBody Book newbook){
        bookservice.updatebook(book_id,newbook);
        return ". updated";
    }

    @DeleteMapping("deletebook")
    public String deletebook(@RequestParam Integer book_id){
        Book book=bookrepository.findById(book_id).get();
        Integer id=book.getStudent().getStudent_id();
        Student student=studentrepository.findById(id).get();
        studentrepository.delete(student);
        bookservice.deletebook(book);
        return "book delete successfully";
    }
}
