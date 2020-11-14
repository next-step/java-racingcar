package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import racingcar.behavior.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RacingCarTest {
    private static final int DEFAULT_DISTANCE = 0;
    private static final int MOVE = 1;
    private static final int NOT_MOVE = 0;
    private final int round = 3;

    private final String[] nameOfCars = {"car1", "car2", "car3", "car4"};
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = RacingCars.of(nameOfCars, () -> true,round);
        racingCars.run();
    }

    @DisplayName("게임에 필요한 Car 를 생성자의 인자로 받아 원하는 인자를 가진 Car로 생성 여부")
    @Test
    void createTest() {
        assertThatCode(() -> RacingCars.of(nameOfCars, new RandomMovingStrategy(),round))
                .doesNotThrowAnyException();
    }

    @DisplayName("초기화된 Cars의 위치가 시작점 0인 경우")
    @Test
    void initialCars() {
        RacingCars initRacingCar = RacingCars.of(nameOfCars, new RandomMovingStrategy(),round);
        assertThat(initRacingCar.getCars()
                .stream()
                .map(Car::getPosition))
                .contains(DEFAULT_DISTANCE);
    }

    @DisplayName("입력한 Car의 수와 생성된 Cars의 사이즈 일치 여부 (of 메소드) ")
    @Test
    void initialCarsSize() {
        List<Car> cars = racingCars.getCars();
        assertThat(cars).hasSize(4);
    }

    @DisplayName("게임을 한 번 수행할 때마다 만들어진 Car 는 이동 또는 정지 여부")
    @ParameterizedTest
    @MethodSource("moveCarsCase")
    void moveOrStopCar(boolean moveOrNot, int distance, int round) {
        RacingCars racingCars = RacingCars.of(nameOfCars, () -> moveOrNot,round);
        racingCars.run();
        assertThat(racingCars.getCars()
                .stream()
                .map(Car::getPosition))
                .containsOnly(distance);
    }

    private static Stream<Arguments> moveCarsCase() {
        return Stream.of(
                Arguments.of(true, MOVE,3),
                Arguments.of(false, NOT_MOVE,7)
        );
    }

    @DisplayName("게임 한번 수행시, 우승자 출력")
    @Test
    void getWinners() {
        racingCars.run();
        List<String> winners = racingCars.getNamesOfWinnerCars()
                .stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
        assertThat(winners).containsExactly("car1", "car2", "car3", "car4");
    }

    @DisplayName("Car 최대 이동거리 일치 여부")
    @Test
    void carMaxPosition() {
        int maxPosition = getMaxPosition();
        assertThat(racingCars.getMaxPosition()).isEqualTo(maxPosition);
    }

    private int getMaxPosition() {
        return racingCars.getCars().
                stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(NOT_MOVE);
    }

    @DisplayName("다음 라운드 정상 진행 여부")
    @Test
    void nextRoundTest() {
        racingCars = RacingCars.of(nameOfCars, () -> true, round);
        racingCars.run();
        assertThat(racingCars.nextRound()).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("마지막 라운드 시 true 반환 여부")
    @ValueSource(ints = {3, 5, 7})
    void finalRoundTest(int round) {
        racingCars = RacingCars.of(nameOfCars, () -> true, round);
        for (int i = 0; i < round; i++) {
            racingCars.run();
        }
        assertThat(racingCars.isLastRound()).isTrue();
    }
}