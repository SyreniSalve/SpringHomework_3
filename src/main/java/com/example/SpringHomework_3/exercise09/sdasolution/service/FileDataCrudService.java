package com.example.SpringHomework_3.exercise09.sdasolution.service;

import com.example.SpringHomework_3.exercise09.sdasolution.exception.SdaException;
import com.example.SpringHomework_3.exercise09.sdasolution.module.FileData;
import com.example.SpringHomework_3.exercise09.sdasolution.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
@RequiredArgsConstructor
public class FileDataCrudService {

    private final FileDataRepository fileDataRepository;

    public FileData findById(final UUID id){
        return fileDataRepository.findById(id)
                .orElseThrow(() -> new SdaException("Cannot find file data with given id"));
    }

    public List<FileData> getAll(){
        return  new ArrayList<>(fileDataRepository.findAllBy());
    }

    public FileData create(final FileData fileData){
        fileData.setId(null);
        return fileDataRepository.save(fileData);
    }

    public void update(final UUID id, final FileData fileData){
        FileData existingFileData = fileDataRepository.findById(id)
                .orElseThrow(() -> new SdaException("Cannot update non existing file data"));
        existingFileData.setContent(fileData.getContent());
        existingFileData.setExtension(fileData.getExtension());
        existingFileData.setSizeInKb(fileData.getSizeInKb());
        existingFileData.setName(fileData.getName());
        fileDataRepository.save(existingFileData);
    }

    public void delete(final UUID id) {
        fileDataRepository.findById(id)
                .orElseThrow(() -> new SdaException("Cannot delete non existing file data"));
        fileDataRepository.deleteById(id);
    }
}
