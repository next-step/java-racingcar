package racingcar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private String questionCarNumbers = "자동차 대수는 몇 대 인가요?";

    private String questionTryNumbers = "시도할 회수는 몇 회 인가요?";

    public int numberOfCars() {
        System.out.println(questionCarNumbers);
        return scanner.nextInt();
    }

    public int tryCount() {
        System.out.println(questionTryNumbers);
        return scanner.nextInt();
    }

}
