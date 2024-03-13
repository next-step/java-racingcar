package racingcar;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    static Validator validator = new Validator();

    public static String numberOfCar(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextLine();
    }
    public static String tryCntInput() {
        System.out.println("시도할 횟 수는 몇 회 인가요?");
        return scanner.nextLine();
    }
    public static int inputNumber(String value){
        return numberCheck(value);
    }

    public static Integer numberCheck(String value){
        validator.numericCheck(value);
        validator.nullCheck(value);
        return Integer.parseInt(value);
    }
}
