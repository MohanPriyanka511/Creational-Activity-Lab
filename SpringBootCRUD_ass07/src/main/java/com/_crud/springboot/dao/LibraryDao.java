package com._crud.springboot.dao;
import org.springframework.data.jpa.repository.JpaRepository; 
import com._crud.springboot.entity.Library; 
public interface LibraryDao extends JpaRepository<Library, Long> { 
}