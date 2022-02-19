package com.example.SpringHomework_3.exercise09.mysolution.controller;

import com.example.SpringHomework_3.exercise09.mysolution.module.FilesData;
import com.example.SpringHomework_3.exercise09.mysolution.service.FilesDataService;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/files-data")
public class FilesDataController {

    private final FilesDataService filesDataService;

    public FilesDataController(final FilesDataService filesDataService) {
        this.filesDataService = filesDataService;
    }

    @GetMapping("/all-data")
    public ResponseEntity<Iterable<FilesData>> allFilesData(){
        Iterable<FilesData> listOfFilesData = filesDataService.findAllFilesData();
        return new ResponseEntity<>(listOfFilesData, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findFilesDataById(@PathVariable("id") String id){
        FilesData filesDataById = filesDataService.findFilesDataById(id);
        return new ResponseEntity<>(filesDataById, HttpStatus.OK);
    }

    @SneakyThrows
    @PostMapping("/add-data")
    public ResponseEntity<Object> addFilesData(@RequestBody FilesData filesData) {
        filesDataService.addFilesData(filesData);
        return new ResponseEntity<>(HttpStatus.CREATED);
//        final String newFilesDataId = newFilesData.getId();
//        final URI location = uriBuilder.path(newFilesData.getId()).build();
//        return ResponseEntity.created(location).build();
    }

    @PutMapping("update-data/{id}")
    public ResponseEntity<Void> updateFilesDataById(@PathVariable("id") String id, @RequestBody FilesData filesData){
        FilesData filesDataById = filesDataService.findFilesDataById(id);
        filesDataById.setFileName(filesData.getFileName());
        filesDataById.setExtension(filesData.getExtension());
        filesDataById.setSizeInKb(filesData.getSizeInKb());
        filesDataById.setContent(filesData.getContent());

        filesDataService.updateFilesData(filesDataById);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete-data/{id}")
    public ResponseEntity<Void> deleteFilesDataById(@PathVariable("id") String id){
        FilesData filesDataById = filesDataService.findFilesDataById(id);
        filesDataService.deleteFilesData(filesDataById);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
