package racing.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String DEFAULT_DELIMITERS = ",";

    public static int requestNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return isPositiveNumber(scanner.nextInt());
    }

    public static String[] requestCarWithName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return split(scanner.nextLine());
    }

    public static int requestNumberOfRound() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return isPositiveNumber(scanner.nextInt());
    }

    private static int isPositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format("음수를 사용할 수 없습니다. 입력 값 :[%s]", number));
        }
        return number;
    }

    public static String[] split(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }
}
