package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NUMBER_IUNPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String getCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static int getTryNumber() {
        System.out.println(TRY_NUMBER_IUNPUT_MESSAGE);
        return scanner.nextInt();
    }
}
