package com.codecool.filepartreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

        if(toLine < fromLine || fromLine < 1) throw new IllegalArgumentException("Invalid line declaration!");
    }

    private String read() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(this.filePath));
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();
        return text;
    }

    public String readLines() throws FileNotFoundException {
        String fileText = read();
        List<String> textRows = Arrays.asList(fileText.split("\n"));

        if(this.fromLine != null && this.toLine != null) {
            int actualToLine = this.toLine--;
            if(this.fromLine.equals(this.toLine)) {
                return textRows.get(this.fromLine--);
            }
            StringBuilder stringBetween = new StringBuilder();
            for(int from = this.fromLine; from < actualToLine; from++) {
                String textRow = textRows.get(from) + "\n";
                stringBetween.append(textRow);
            }
            return stringBetween.toString().trim();
        }
        return null;
    }
}
