package view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUND_GUIDE = "시도할 회수는 몇 회 인가요?";

    static Scanner scanner = new Scanner(System.in);

    private InputView() {};

    public static String[] getNamesOfCars(){
        System.out.println(CAR_GUIDE);
        String carNameString = scanner.nextLine();
        checkCarNamesValue(carNameString);
        return splitString(carNameString);
    }

    public static int getRound() {
        System.out.println(ROUND_GUIDE);
        int round = scanner.nextInt();
        checkRoundValue(round);
        return round;
    }

    public static void checkRoundValue(int inputValue) {
        if(inputValue <= 1 || inputValue != (int)inputValue) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCarNamesValue(String inputValue) {
        if(inputValue == null || inputValue.trim().equals("")) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] splitString(String inputValue) {
        return inputValue.split(",");
    }

}
