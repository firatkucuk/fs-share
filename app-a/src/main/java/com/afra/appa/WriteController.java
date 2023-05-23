package com.afra.appa;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriteController {

    @Value("${storage-path:/tmp}")
    private String storagePath;

    @PostMapping("/write/{fileName}")
    public String writeToFile(@PathVariable final String fileName, @RequestBody final String data) throws IOException {
        final Path createdFile = Files.createFile(new File(this.storagePath + "/" + fileName).toPath());
        Files.writeString(createdFile, data, Charset.defaultCharset());
        return "succeeded";
    }
}
