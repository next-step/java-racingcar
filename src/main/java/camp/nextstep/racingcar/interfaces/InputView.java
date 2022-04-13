package camp.nextstep.racingcar.interfaces;

import camp.nextstep.racingcar.domain.RacingCarGameInputData;

import java.util.Scanner;

public class InputView {

    public static RacingCarGameInputData getRacingCarGameInputData() {
        Scanner scanner = new Scanner(System.in);

        // Ask for user input
        System.out.println("자동차 대수는 몇 대인가요?");
        int countOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int rounds = scanner.nextInt();

        return new RacingCarGameInputData(countOfCar, rounds);
    }

}
