package carRacing.view;

import carRacing.model.Validator;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static String numberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextLine();
    }

    public static String numberOfRace() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextLine();
    }

    public int inputNumber(String values){
        return numberCheck(values);
    }

    Validator validator = new Validator();

    public Integer numberCheck(String inNumber) {
        validator.numericCheck(inNumber);
        validator.nullCheck(inNumber);
        return Integer.parseInt(inNumber);
    }
}
