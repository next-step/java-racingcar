package racingcar.view;

import racingcar.model.TrialCount;
import racingcar.util.StringUtil;
import racingcar.model.Car;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).";

    private static final String TRIAL_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final String DEFAULT_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    private int readNumber() {
        return scanner.nextInt();
    }

    private String readCarNames() {
        return scanner.nextLine();
    }

    public List<Car> inputCars() {
        System.out.println(CAR_NAMES_MESSAGE);
        List<String> carNames = StringUtil.split(readCarNames(), DEFAULT_DELIMITER);
        return carNames.stream().map(Car::from).collect(Collectors.toList());
    }

    public TrialCount inputTrialCount() {
        System.out.println(TRIAL_COUNT_MESSAGE);
        return new TrialCount(readNumber());
    }

}
