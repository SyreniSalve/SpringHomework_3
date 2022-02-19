package com.example.SpringHomework_3.exercise09.sdasolution.repository;

import com.example.SpringHomework_3.exercise09.sdasolution.module.FileData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface FileDataRepository extends CrudRepository<FileData, UUID> {
    List<FileData> findAllBy();
}
