package com.example.Student_management_System.Service;

import com.example.Student_management_System.Dao.IBookrepository;
import com.example.Student_management_System.Dao.IStudentrepository;
import com.example.Student_management_System.Model.Book;
import com.example.Student_management_System.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Bookservice {


    @Autowired
    IBookrepository bookrepository;

    @Autowired
    IStudentrepository studentrepository;

    public void savebook(Book books) {
        Student student=studentrepository.findById(books.getStudent().getStudent_id()).get();
        books.setStudent(student);
        bookrepository.save(books);
    }

    public List<Book> getbooks(Integer bookId) {
        List<Book> books;
        if(bookId!=null){
            books=new ArrayList<>();
            books.add(bookrepository.findById(bookId).get());
        }
        else{
            books=bookrepository.findAll();
        }
        return books;
    }

    public void updatebook(Integer bookId, Book newbook) {

        Book oldbook=bookrepository.findById(bookId).get();

        newbook.setBook_id(oldbook.getBook_id());

        bookrepository.save(newbook);
    }

    public void deletebook(Book book) {

        bookrepository.delete(book);
    }
}
