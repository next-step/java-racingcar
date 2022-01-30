package racinggame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SEPARATOR = ",";

    public static List<String> getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            List<String> carNames = Arrays.asList(userInput.split(SEPARATOR));
            return carNames;
        }
    }

    public static int getTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}