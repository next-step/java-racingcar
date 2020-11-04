package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokenizer {
    String[] inputArr;
    public Tokenizer(String input){
        this.inputArr = input.split(" ");
    }

    public List<Integer> extractNumber(){
        List<String> tempList =  Arrays.stream(this.inputArr)
                .filter( input -> input.matches("[0-9]")).collect(Collectors.toList());

        return tempList.stream().map( num -> Integer.parseInt(num))
                .collect(Collectors.toList());
    }

    public List<String> extractOperator(){
        return Arrays.stream(this.inputArr)
                .filter(input -> input.matches("[*/+-]"))
                .collect(Collectors.toList());
    }

}
