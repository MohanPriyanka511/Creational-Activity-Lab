package com._crud.springboot.controller;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.*; 
import org.springframework.web.bind.annotation.*;

import com._crud.springboot.entity.Library;
import com._crud.springboot.service.LibraryService; 
@RestController
@RequestMapping("/api")
public class MyController  {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/library")
    public ResponseEntity<List<Library>> getLibraries() {
        List<Library> libraries = libraryService.getLibrarys();
        return ResponseEntity.ok(libraries);
    }

    @GetMapping("/library/{bookId}")
    public ResponseEntity<Library> getLibrary(@PathVariable Long bookId) {
        Library library = libraryService.getLibrary(bookId);
        if (library == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(library);
    }

    @PostMapping("/library")
    public ResponseEntity<Library> addLibrary(@RequestBody Library library) {
        Library addedLibrary = libraryService.addLibrary(library);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedLibrary);
    }

    @PutMapping("/library")
    public ResponseEntity<Library> updateLibrary(@RequestBody Library library) {
        Library existingLibrary = libraryService.getLibrary(library.getBookId());
        if (existingLibrary == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Library updatedLibrary = libraryService.updateLibrary(library);
        return ResponseEntity.ok(updatedLibrary);
    }

    @DeleteMapping("/library/{bookId}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long bookId) {
        try {
            libraryService.deleteLibrary(bookId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
