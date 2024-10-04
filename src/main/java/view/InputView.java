package view;

import util.Validator;

import java.util.Scanner;

public class InputView {
    private static Scanner SC = new Scanner(System.in);

    public static int getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int num = Integer.parseInt(SC.nextLine());
        if (!Validator.isValidNumberOfCars(num)) {
            throw new IllegalArgumentException("0이상 입력 해주세요");
        }
        return num;
    }

    public static int getNumberOfGames() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int num = Integer.parseInt(SC.nextLine());
        if (!Validator.isValidNumberOfGames(num)) {
            throw new IllegalArgumentException("0이상 입력 해주세요");
        }
        return num;
    }

    public static String[] getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SC.nextLine().split(",");
    }

}
