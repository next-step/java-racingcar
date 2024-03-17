package carRacing.view;

import carRacing.model.Validator;

import java.util.List;
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

    public static String nameOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int inputNumber(String values){
        return numberCheck(values);
    }

//    public static String inputName(String values) {
//        return nameCheck(values);
//    }

    static Validator validator = new Validator();

    public static Integer numberCheck(String inNumber) {
        validator.numericCheck(inNumber);
        validator.checkNull(inNumber);
        return Integer.parseInt(inNumber);
    }

    public static List<String> inputCarNames() {;
        String inCarName = InputView.nameOfCar();
        return List.of(inCarName.split(","));
    }

}
