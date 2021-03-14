package step4;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {

    static int getNumberInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        checkInputNull(input);
        checkInputNumeric(input);
        return Integer.parseInt(input);
    }

    static void checkInputNumeric(String input){
        String numberRegExp = "^[0-9]+$";
        if(!input.matches(numberRegExp)){
            throw new IllegalArgumentException("Input must be numeric");
        }
    }

    static String getInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        checkInputNull(input);
        return input;
    }

    static void checkInputNull(String input){
        if(input == null || input.trim().isEmpty()){
            throw new NoSuchElementException("Input cannot be blank or null");
        }
    }

    static String[] splitInput(String input){
        String[] carNames = Arrays.stream(input.split(CarRacingConstant.COMMA)).map(String::trim).toArray(String[]::new);
        checkCarNamesLength(carNames);
        return carNames;
    }

    static void checkCarNamesLength(String[] carNames){
        Arrays.stream(carNames)
                .filter(name -> name.length() > CarRacingConstant.LIMIT_OF_NAME_LENGTH)
                .findAny()
                .ifPresent(present -> {
                    throw new IllegalArgumentException();
                });
    }

}
