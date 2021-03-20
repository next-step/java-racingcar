package step4.view;

import step4.model.CarRacingConstant;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {

    public static int getNumberInput(){
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

    public static String getInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        checkInputNull(input);
        return input;
    }

    static void checkInputNull(String input){
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("Input cannot be blank or null");
        }
    }

    public static String[] splitInput(String input){
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
