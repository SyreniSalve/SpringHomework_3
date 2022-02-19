package com.example.SpringHomework_3.exercise09.mysolution.service;

import com.example.SpringHomework_3.exercise09.mysolution.exception.FilesDataException;
import com.example.SpringHomework_3.exercise09.mysolution.module.FilesData;
import com.example.SpringHomework_3.exercise09.mysolution.repository.FilesDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilesDataService {

    private final FilesDataRepository filesDataRepository;

    @Autowired
    public FilesDataService(final FilesDataRepository filesDataRepository) {
        this.filesDataRepository = filesDataRepository;
    }

    public List<FilesData> findAllFilesData(){
        return filesDataRepository.findAll();
    }

    public FilesData findFilesDataById(String id){
        return filesDataRepository.findFilesDataById(id).orElseThrow(
                ()-> new FilesDataException("Files data by id " + id + " not found")
        );
    }

    public FilesData addFilesData(FilesData filesData){
        filesData.setId(UUID.randomUUID().toString());
        return filesDataRepository.save(filesData);
    }

    public void updateFilesData(FilesData filesData){
        filesDataRepository.save(filesData);
    }

    public void deleteFilesData(FilesData filesData){
        filesDataRepository.delete(filesData);
    }
}
