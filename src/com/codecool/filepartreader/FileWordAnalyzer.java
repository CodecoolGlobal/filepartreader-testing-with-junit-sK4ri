package com.codecool.filepartreader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class FileWordAnalyzer {

    private FilePartReader filePartReader;


    FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }


    ArrayList wordsByABC() throws FileNotFoundException {
        String fileText = filePartReader.readLines();
        String[] fileLines = fileText.split("\n");
        Arrays.sort(fileLines);

        return new ArrayList<>(Arrays.asList(fileLines));
    }


    List wordsContainingSubString(String subString ) throws FileNotFoundException {
        String fileText = filePartReader.readLines();
        String[] fileLines = fileText.split("\n");
        List<String> wordsContainingSubStr = new ArrayList<>();

        for (String word:fileLines){
            if (word.contains(subString)){
                wordsContainingSubStr.add(word);
            }
        }
        return wordsContainingSubStr;
    }


    List wordsArePalindrome () throws FileNotFoundException {
        filePartReader.setup("data.txt",1,100);
        String fileText = filePartReader.readLines();
        String[] fileLines = fileText.split("\n");
        List<String> palindromes = new ArrayList<>();

        for (String word:fileLines){
            boolean isPalindrom = isPalindrom(word);
            if (isPalindrom){
                palindromes.add(word);
            }
        }
        return palindromes;
    }


    private boolean isPalindrom(String word){
        String[] splittedWord = word.split("");
        int i1 = 0;
        int i2 = splittedWord.length - 1;
        while (i2 > i1) {
            if (!(splittedWord[i1].equals(splittedWord[i2]))) {
                return false;
            }

            ++i1;
            --i2;
        }
        return true;
    }
}
