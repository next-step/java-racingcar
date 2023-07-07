package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.response.RacingGamePlayResponse;
import racingcar.domain.response.RacingGamePlayResponse.CarPerRoundResponse;
import racingcar.domain.response.RacingGamePlayResponse.RacingGameRoundResponse;
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
        Asserts.isTrue(round >= INITIAL_ROUND, () -> "round값은 0보다 작아질 수 없습니다. round \"" + round + "\"");
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
        List<RacingGameRoundResponse> racingGameRoundResponses = readyGame();
        for (int currentRound = FIRST_ROUND; currentRound <= round; currentRound++) {
            moveCars();
            racingGameRoundResponses.add(new RacingGameRoundResponse(currentRound, currentCarStatusToResponse()));
        }

        return new RacingGamePlayResponse(getWinnerNames(), racingGameRoundResponses);
    }

    private List<RacingGameRoundResponse> readyGame() {
        List<RacingGameRoundResponse> racingGameRoundResponses = new ArrayList<>();

        racingGameRoundResponses.add(new RacingGameRoundResponse(INITIAL_ROUND, currentCarStatusToResponse()));

        return racingGameRoundResponses;
    }

    private List<CarPerRoundResponse> currentCarStatusToResponse() {
        return cars.stream()
            .map(car -> new CarPerRoundResponse(car.getName(), car.getPosition()))
            .collect(Collectors.toList());
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<String> getWinnerNames() {
        int winnerPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException("Cars 배열이 비어있습니다."));

        return cars.stream()
            .filter(car -> isWinner(car.getPosition(), winnerPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private boolean isWinner(int currentPosition, int winnerPosition) {
        return currentPosition == winnerPosition;
    }

}
