package com._crud.springboot.service;
import java.util.List;

import com._crud.springboot.entity.Library; 
public interface LibraryService { 
List<Library> getLibrarys(); 
Library getLibrary(long bookId); 
Library addLibrary(Library library); 
Library updateLibrary(Library library); 
void deleteLibrary(long bookId); 
}