package com.command.tail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileReaderController {

    /**
     * Controller method to read last n lines from a file
     * @param path {@link String}
     * @param numLastLineToRead {@link int}
     * @return {@link List<String>}
     */
    @GetMapping("/tail")
    public static List<String> readLastLine(@RequestParam String path, @RequestParam int numLastLineToRead) {

        BufferedReader reader;

        String line = null;
        List<String> ans = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(path));
            line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
                if (ans.size() > numLastLineToRead) {
                    break;
                }
                ans.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ans;
    }

}
