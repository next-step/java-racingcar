package racing.domain;

import java.util.List;
import java.util.Scanner;

public class UserInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private UserInput() {
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Parser.split(SCANNER.nextLine());
    }

    public static int getTryNumber() {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            return new TryNumber(SCANNER.nextLine()).getTryNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryNumber();
        }
    }
}
