package com.example.SpringHomework_3.exercise09.sdasolution.collection;

import com.example.SpringHomework_3.exercise09.sdasolution.module.FileData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDataCollection {
    private List<FileData> filesData;
}
