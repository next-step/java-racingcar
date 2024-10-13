package racing;

import racing.domain.UserInput;

import java.util.Scanner;

public class InputView {

    public static UserInput readInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int totalCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int totalRacingCounts = scanner.nextInt();

        return new UserInput(totalCars, totalRacingCounts);
    }

    public static UserInput readInputWithName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String totalCarNames = scanner.next();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int totalRacingCounts = scanner.nextInt();

        return new UserInput(totalCarNames, totalRacingCounts);
    }
}
