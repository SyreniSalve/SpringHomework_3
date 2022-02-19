package com.example.SpringHomework_3.exercise09.mysolution.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "files_data")
public class FilesData {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
////            parameters = {
////                    @Parameter(
////                            name = "uuid_gen_strategy_class",
////                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
////                    )
////            }
//            )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "file_name")
    private String fileName;

    private Double extension;

    @Column(name = "size_in_kb")
    private Double sizeInKb;

    private byte content;
}
