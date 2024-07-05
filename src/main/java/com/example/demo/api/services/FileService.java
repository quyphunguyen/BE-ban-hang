package com.example.demo.api.services;

import com.example.demo.api.config.NoteContext;
import com.example.demo.api.entity.Files;
import com.example.demo.api.repository.FileRepository;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileService {
    private final Path root = Paths.get(NoteContext.pathImg);
    @Autowired
    private FileRepository fileRepository;

    @Autowired
    ServletContext context;

    public Files save(MultipartFile multipartFile) {
        String url = NoteContext.pathImg;
        String fileName = UUID.randomUUID()+"-"+ multipartFile.getOriginalFilename();
        Files file = null;
        try{
            file = new Files();

            Path filepath = Paths.get(url, fileName);

            try (OutputStream os = java.nio.file.Files.newOutputStream(filepath)) {
                os.write(multipartFile.getBytes());
            }

            file.setFileName(fileName);
            file.setUrl(filepath.toString());

            fileRepository.save(file);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return file;

    }

    public boolean deleteFile(String fileName) throws IOException {
        Optional<Files> file =  this.fileRepository.findFirstByFileName(fileName);
        if(!file.isPresent()){
            return false;
        }
        Path path = root.resolve(file.get().getFileName());
        this.fileRepository.delete(file.get());

        return java.nio.file.Files.deleteIfExists(path);
    }


    public List<Files> findAll() {
        List<Files> files = this.fileRepository.findAll();
        String absolutePath = new FileSystemResource("").getFile().getAbsolutePath();
        for(Files file: files){
            file.setUrl(absolutePath+file.getUrl());
            System.out.println(file.getUrl());
        }
        return files;

    }




}
