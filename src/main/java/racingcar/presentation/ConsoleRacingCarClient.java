package racingcar.presentation;

import racingcar.domain.dto.RacingCarInput;
import racingcar.domain.vo.NumberOfCars;
import racingcar.domain.vo.NumberOfTrials;

import java.util.Scanner;

public class ConsoleRacingCarClient implements RacingCarClient {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public RacingCarInput getRacingCarInput() {
        final NumberOfCars numberOfCars = getNumberOfCars();
        final NumberOfTrials numberOfTrials = getNumberOfTrials();
        scanner.close();

        return new RacingCarInput(numberOfCars, numberOfTrials);
    }

    public NumberOfCars getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        final String input = scanner.nextLine();
        try {
            final int parsed = Integer.parseInt(input);
            return NumberOfCars.from(parsed);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format("자동차 대수를 양의 숫자로 입력해주세요 : %s", input), e);
        }
    }

    public NumberOfTrials getNumberOfTrials() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        final String input = scanner.nextLine();
        try {
            final int parsed = Integer.parseInt(input);
            return NumberOfTrials.from(parsed);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format("시도 횟수를 양의 숫자로 입력해주세요 : %s", input), e);
        }
    }
}
