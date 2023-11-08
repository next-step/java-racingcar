package carracing.ui;

import carracing.dto.CarRaceRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_SEPARATOR = ",";

    private final List<String> carNames = new ArrayList<>();
    private final int movingCount;


    public InputView(List<String> carNames, int movingCount) {
        this.carNames.addAll(carNames);
        this.movingCount = movingCount;
    }

    public static InputView input() {
        return new InputView(inputCarNames(), inputMovingCount());
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return List.of(SCANNER.nextLine().split(CAR_SEPARATOR));
    }

    private static int inputMovingCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return parseInt(SCANNER.nextLine());
    }

    public CarRaceRequest toRequest() {
        return new CarRaceRequest(carNames, movingCount);
    }
}
