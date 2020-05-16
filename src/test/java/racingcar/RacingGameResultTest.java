package racingcar;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;
import racingcar.domain.game.RacingGameResult;
import racingcar.domain.strategy.RandomMovableStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RacingGameResultTest {

    RacingGameResult result;

    @BeforeEach
    void setUp(){
        result = new RacingGameResult();
    }
    @Test
    @DisplayName("RacingResult 객체 생성 테스트")
    public void generateRacingGameResultTest() {
        assertThatCode(() -> new RacingGameResult()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("RacingResult 객체 생성 시 레이싱 게임 결과는 비어있다.")
    public void resultSizeTest() {
        assertThat(new RacingGameResult().getResults()).hasSize(0);
    }

    @Test
    @DisplayName("RacingResult 추가 테스트")
    public void racingGameResultAddTest() {
        assertThatCode(() -> result.add("ray", 1)).doesNotThrowAnyException();
        result.add("ray", 2);
        result.add("sonata", 2);

        assertThat(result.getResults().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("RacingGame play 이후 우승자를 가져올 때 에러가 발생하지 않는다.")
    public void getWinnerTest() {
        assertThatCode(() -> result.getWinner()).doesNotThrowAnyException();
    }

    @MethodSource("generateCarsAndWinnerArgument")
    @ParameterizedTest
    @DisplayName("RacingResult 우승자 계산 테스트")
    public void GetWinnerTest(List<Car> cars, String expectedCarName, int expectedSize) {
        for (Car car : cars) {
            result.add(car.getName(), car.getPosition());
        }
        assertThat(result.getWinner()).contains(expectedCarName);
        assertThat(result.getWinner()).hasSize(expectedSize);
    }

    private static Stream<Arguments> generateCarsAndWinnerArgument() {
        List<Car> cars = Arrays.asList(
                Car.newInstance(CarPosition.of(0), CarName.of("sonata"), new RandomMovableStrategy()),
                Car.newInstance(CarPosition.of(1), CarName.of("k5"), new RandomMovableStrategy()),
                Car.newInstance(CarPosition.of(2), CarName.of("ray"), new RandomMovableStrategy())
        );
        return Stream.of(
                Arguments.of(cars, "ray", 1)
        );
    }
}
