package com.example.SpringHomework_3.exercise09.sdasolution.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "files_data2")
public class FileData {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "file_name")
    private String name;

    @Column(name = "extension")
    private String extension;

    @Column(name = "size_in_kb")
    private Integer sizeInKb;

    @Column(name = "content")
    private String content;
}
