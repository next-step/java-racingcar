package step3;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {

    static int getInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        validateInput(input);
        return Integer.parseInt(input);
    }

    static int getInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        return getInput();
    }


    static void validateInput(String input){
        String numberRegExp = "^[0-9]+$";
        if(!input.matches(numberRegExp)){
            throw new IllegalArgumentException("Input must be numeric");
        }
        if(input == null || input.trim().isEmpty()){
            throw new NoSuchElementException("Input cannot be blank or null");
        }
    }

}
