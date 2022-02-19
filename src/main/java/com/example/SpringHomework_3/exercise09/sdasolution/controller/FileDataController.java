package com.example.SpringHomework_3.exercise09.sdasolution.controller;

import com.example.SpringHomework_3.exercise09.sdasolution.collection.FileDataCollection;
import com.example.SpringHomework_3.exercise09.sdasolution.module.FileData;
import com.example.SpringHomework_3.exercise09.sdasolution.service.FileDataCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(FileDataController.FILE_DATA_API_BASE_PATH)
public class FileDataController {

    static final String FILE_DATA_API_BASE_PATH = "/api/v1";

    private final FileDataCrudService fileDataCrudService;

    @GetMapping
    public FileDataCollection getAll(){
        return new FileDataCollection(fileDataCrudService.getAll());
    }

    @GetMapping("{id}")
    public FileData getById(@PathVariable final UUID id) {
        return fileDataCrudService.findById(id);
    }

    @PostMapping
    public ResponseEntity<FileData> create(@RequestBody final FileData fileData) throws URISyntaxException {
        return  ResponseEntity
                .created(new URI(FILE_DATA_API_BASE_PATH + "/" + fileDataCrudService.create(fileData).getId().toString()))
                .build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody final FileData fileData, @PathVariable final UUID id){
        fileDataCrudService.update(id, fileData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final UUID id){
        fileDataCrudService.delete(id);
    }
}
