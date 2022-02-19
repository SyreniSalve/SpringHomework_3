package com.example.SpringHomework_3.exercise09.mysolution.repository;

import com.example.SpringHomework_3.exercise09.mysolution.module.FilesData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FilesDataRepository extends JpaRepository<FilesData, String> {

   Optional<FilesData> findFilesDataById(String id);
}
