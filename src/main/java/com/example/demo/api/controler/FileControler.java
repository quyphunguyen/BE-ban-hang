package com.example.demo.api.controler;

import com.example.demo.api.entity.Files;
import com.example.demo.api.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.FileTypeMap;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api")
public class FileControler {
    @Autowired
    private FileService fileService;

    @PostMapping(value = { "/file/save" })
    public Files save(@RequestParam("image") MultipartFile multipartFile) {
        Files file = this.fileService.save(multipartFile);
        return file;
    }

    @GetMapping(value = { "/file/delete" })
    public Boolean deleteFile(@RequestParam("fileName") String fileName) throws IOException {
        return this.fileService.deleteFile(fileName);
    }


    @GetMapping(value = { "/file/findAll" })
    public List<Files> findAll() {
        List<Files> files = this.fileService.findAll();
        return files;
    }


    @GetMapping("/file/thing")
    public ResponseEntity<byte[]> what() throws IOException {
        java.io.File file = new java.io.File("J:\\project ngoai\\CHUAN\\BE-ban-hang\\src\\assets\\images\\Screenshot.png");
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" +file.getName())
                .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(file)))
                .body(java.nio.file.Files.readAllBytes(file.toPath()));
    }

}
