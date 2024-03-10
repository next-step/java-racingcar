package racingcar.presentation;

import racingcar.domain.Car;
import racingcar.domain.dto.RacingCarRequest;
import racingcar.domain.dto.RacingCarResult;
import racingcar.domain.vo.NumberOfCars;
import racingcar.domain.vo.NumberOfTrials;

import java.util.List;
import java.util.Scanner;

public class ConsoleRacingCarClient implements RacingCarClient {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String PROGRESS_CHARACTER = "-";
    private static final String MESSAGE_FOR_CAR_INPUT_REQUEST = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_FOR_TRIAL_INPUT_REQUEST = "시도할 회수는 몇 회 인가요?";
    private static final String MESSAGE_FOR_INVALID_CAR_INPUT = "자동차 대수를 양의 숫자로 입력해주세요 : %s";
    private static final String MESSAGE_FOR_INVALID_TRIAL_INPUT = "시도 횟수를 양의 숫자로 입력해주세요 : %s";
    private static final String RESULT_HEADER = "%s실행 결과%s";
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public RacingCarRequest getRacingCarInput() {
        final NumberOfCars numberOfCars = getNumberOfCars();
        final NumberOfTrials numberOfTrials = getNumberOfTrials();
        scanner.close();

        return new RacingCarRequest(numberOfCars, numberOfTrials);
    }

    private NumberOfCars getNumberOfCars() {
        System.out.println(MESSAGE_FOR_CAR_INPUT_REQUEST);
        final String input = scanner.nextLine();
        try {
            final int parsed = Integer.parseInt(input);
            return NumberOfCars.from(parsed);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format(MESSAGE_FOR_INVALID_CAR_INPUT, input), e);
        }
    }

    private NumberOfTrials getNumberOfTrials() {
        System.out.println(MESSAGE_FOR_TRIAL_INPUT_REQUEST);
        final String input = scanner.nextLine();
        try {
            final int parsed = Integer.parseInt(input);
            return NumberOfTrials.from(parsed);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format(MESSAGE_FOR_INVALID_TRIAL_INPUT, input), e);
        }
    }

    @Override
    public void showResultHeader() {
        System.out.printf(RESULT_HEADER, LINE_SEPARATOR, LINE_SEPARATOR);
    }

    @Override
    public void showRacingCarResult(final RacingCarResult racingCarResult) {
        final List<Car> cars = racingCarResult.getCars();
        cars.forEach(car -> System.out.println(PROGRESS_CHARACTER.repeat(car.getPosition())));

        System.out.println();
    }
}
