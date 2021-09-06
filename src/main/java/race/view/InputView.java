package race.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String messageRegisterCar = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final String messageGameCount = "시도할 회수는 몇 회 인가요?";

    private static int inputAnswerToInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static List<String> carNamesToList() {
        System.out.println(messageRegisterCar);
        Scanner input = new Scanner(System.in);
        return splitInput(input.nextLine());
    }

    public static int gameCountInputOutput() {
        System.out.println(messageGameCount);
        return inputAnswerToInt();
    }

    private static List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }
}
