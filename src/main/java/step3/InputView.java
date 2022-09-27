package step3;

import java.util.Scanner;

public class InputView {
    public static final String Q_CAR_NUMBER = "자동차 대수는 몇 대 인가요?";
    public static final String Q_TRY_TIMES = "시도할 회수는 몇 회 인가요?";
    Scanner scanner = new Scanner(System.in);

    public static int printQuestion(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }

    public String inputString() {
        return scanner.nextLine();
    }
}
