package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.extension.Moveable;
import racingcar.domain.response.RacingGamePlayResponse;
import racingcar.domain.response.RacingGamePlayResponse.CarPerRoundResponse;
import racingcar.domain.response.RacingGamePlayResponse.RacingGameRoundResponse;
import racingcar.util.Asserts;

public class RacingGame {

    private static final int INITIAL_ROUND = 0;
    private static final int FIRST_ROUND = 1;

    private final Round round;
    private final Cars cars;

    public RacingGame(int round, List<String> carNames, Moveable moveable) {
        this(round, createCarsByCarNames(carNames, moveable));
    }

    private static List<Car> createCarsByCarNames(List<String> carNames, Moveable moveable) {
        return carNames.stream()
            .map(carName -> new Car(carName, moveable))
            .collect(Collectors.toList());
    }

    RacingGame(int round, List<Car> cars) {
        this.round = new Round(round);
        this.cars = new Cars(cars);
    }

    public RacingGamePlayResponse playAndGetRoundResults() {
        List<RacingGameRoundResponse> racingGameRoundResponses = readyGame();
        for (int currentRound = FIRST_ROUND; currentRound <= round.value; currentRound++) {
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
        return cars.value.stream()
            .map(car -> new CarPerRoundResponse(car.getName(), car.getPosition()))
            .collect(Collectors.toList());
    }

    private void moveCars() {
        for (Car car : cars.value) {
            car.move();
        }
    }

    private List<String> getWinnerNames() {
        int winnerPosition = cars.value.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException("Cars 배열이 비어있습니다."));

        return cars.value.stream()
            .filter(car -> isWinner(car.getPosition(), winnerPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private boolean isWinner(int currentPosition, int winnerPosition) {
        return currentPosition == winnerPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingGame)) {
            return false;
        }
        RacingGame that = (RacingGame) o;
        return round == that.round && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, cars);
    }

    @Override
    public String toString() {
        return "RacingGame{" +
            "round=" + round +
            ", cars=" + cars +
            '}';
    }

    private static final class Round {

        private final int value;

        private Round(int value) {
            Asserts.isTrue(value >= INITIAL_ROUND, () -> "round값은 0보다 작아질 수 없습니다. round \"" + value + "\"");
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Round)) {
                return false;
            }
            Round round = (Round) o;
            return value == round.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Round{" +
                "value=" + value +
                '}';
        }
    }

    private static final class Cars {

        private final List<Car> value;

        private Cars(List<Car> value) {
            Asserts.isFalse(value.isEmpty(), () -> "입력값 cars 리스트의 사이즈가 0 입니다.");
            assertDuplicateCarName(value);
            this.value = value;
        }

        private void assertDuplicateCarName(List<Car> cars) {
            Set<String> duplicatedName = new HashSet<>();
            for (Car car : cars) {
                Asserts.isTrue(!duplicatedName.contains(car.getName()), () -> "중복된 자동차 이름이 발견됐습니다.");
                duplicatedName.add(car.getName());
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Cars)) {
                return false;
            }
            Cars cars = (Cars) o;
            return Objects.equals(value, cars.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Cars{" +
                "value=" + value +
                '}';
        }
    }

}
