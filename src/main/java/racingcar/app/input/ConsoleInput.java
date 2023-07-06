package racingcar.app.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.controller.request.RacingGamePlayControllerRequest;

public class ConsoleInput {

    private static final String CAR_NAME_SEPERATE_EXPRESSION = ",";

    public RacingGamePlayControllerRequest input() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            List<String> carNames = Arrays.asList(scanner.next().split(CAR_NAME_SEPERATE_EXPRESSION));
            System.out.println("시도할 회수는 몇회인가요?");
            int round = scanner.nextInt();
            return new RacingGamePlayControllerRequest(round, carNames);
        }
    }

}
