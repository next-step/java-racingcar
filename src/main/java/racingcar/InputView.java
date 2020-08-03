package racingcar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public UserArguments createUserArgument() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = this.scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfTrials = this.scanner.nextInt();

        return UserArguments.createUserArgs(numberOfCars, numberOfTrials);
    }
}
