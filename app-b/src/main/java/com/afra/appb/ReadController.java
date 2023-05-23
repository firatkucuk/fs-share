package com.afra.appb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadController {

    @Value("${storage-path:/tmp}")
    private String storagePath;

    @GetMapping("/read/{fileName}")
    public String writeToFile(@PathVariable final String fileName) throws IOException {
        return Files.readString(new File(this.storagePath + "/" + fileName).toPath());
    }
}
