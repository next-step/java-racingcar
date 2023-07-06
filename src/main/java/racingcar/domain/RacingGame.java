package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.response.RacingGamePlayResponse;
import racingcar.util.Asserts;

public class RacingGame {

    private static final int INITIAL_ROUND = 0;
    private static final int FIRST_ROUND = 1;

    private final int round;
    private final List<Car> cars;

    public RacingGame(int round, List<Car> cars) {
        preAssert(round, cars);
        this.round = round;
        this.cars = cars;
    }

    private void preAssert(int round, List<Car> cars) {
        assertNegativeRound(round);
        assertEmptyCars(cars);
        assertDuplicateCarName(cars);
    }

    private void assertNegativeRound(int round) {
        Asserts.isTrue(round >= 0, () -> "round값은 0보다 작아질 수 없습니다. round \"" + round + "\"");
    }

    private void assertEmptyCars(List<Car> cars) {
        Asserts.isFalse(cars.isEmpty(), () -> "입력값 cars 리스트의 사이즈가 0 입니다.");
    }

    private void assertDuplicateCarName(List<Car> cars) {
        Set<String> duplicatedName = new HashSet<>();
        for (Car car : cars) {
            Asserts.isTrue(!duplicatedName.contains(car.getName()), () -> "중복된 자동차 이름이 발견됐습니다.");
            duplicatedName.add(car.getName());
        }
    }

    public RacingGamePlayResponse playAndGetRoundResults() {
        RacingGamePlayResponse response = readyGame();
        for (int currentRound = FIRST_ROUND; currentRound <= round; currentRound++) {
            moveCars();
            response.addRacingGameRoundResponse(currentRound, cars);
        }
        response.setWinner(getWinners());
        return response;
    }

    private RacingGamePlayResponse readyGame() {
        RacingGamePlayResponse racingGamePlayResponse = new RacingGamePlayResponse();

        racingGamePlayResponse.addRacingGameRoundResponse(INITIAL_ROUND, cars);

        return racingGamePlayResponse;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<Car> getWinners() {
        int winnerPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException("Cars 배열이 비어있습니다."));

        return cars.stream()
            .filter(car -> isWinner(car.getPosition(), winnerPosition))
            .collect(Collectors.toList());
    }

    private boolean isWinner(int currentPosition, int winnerPosition) {
        return currentPosition == winnerPosition;
    }

}
