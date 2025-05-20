package com.CRUDOperationSpringBoot.SpringBootCRUD_ass07.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CRUDOperationSpringBoot.SpringBootCRUD_ass07.entity.Library;


@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
}
