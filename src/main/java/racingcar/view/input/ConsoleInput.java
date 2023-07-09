package racingcar.view.input;

import racingcar.controller.request.RacingGamePlayControllerRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

    public RacingGamePlayControllerRequest input() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            List<String> carNames = Arrays.asList(scanner.next().split(","));
            System.out.println("시도할 회수는 몇회인가요?");
            int round = scanner.nextInt();
            return new RacingGamePlayControllerRequest(round, carNames);
        }
    }

}
