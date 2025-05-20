package com._crud.springboot.service;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import com._crud.springboot.dao.LibraryDao;
import com._crud.springboot.entity.Library; 
@Service 
public class LibraryServiceIMPL implements LibraryService { 
@Autowired 
private LibraryDao libraryDao; 
@Override 
public List<Library> getLibrarys() { 
return libraryDao.findAll(); 
} 
@Override 
public Library getLibrary(long bookId) { 
return libraryDao.findById(bookId).orElse(null); 
} 
@Override 
public Library addLibrary(Library library) { 
return libraryDao.save(library); 
} 
@Override 
public Library updateLibrary(Library library) { 
return libraryDao.save(library); 
} 
@Override 
public void deleteLibrary(long bookId) { 
libraryDao.deleteById(bookId); 
} 
}