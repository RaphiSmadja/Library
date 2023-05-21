package com.example.demo.services;

import com.example.demo.dto.BookDTO;
import com.example.demo.entities.BookEntity;
import com.example.demo.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookDTO> getAllBooks() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        return bookEntityList.stream().map(book -> modelMapper.map(book, BookDTO.class)).toList();
    }

    public void saveBook(BookDTO bookDTO) {
        bookRepository.save(modelMapper.map(bookDTO, BookEntity.class));
    }
}
