package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {
    private MovableStrategy movableStrategy = () -> true;

    @DisplayName("생성 시 라운드 수가 0 이하일 경우 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @ValueSource(ints = {-5, 0})
    void create_ThrowsIllegalArgumentException_IfCarCountOrRoundCountUnderOne(int roundCount) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RacingGame(roundCount, movableStrategy));
    }

    @DisplayName("경주")
    @Test
    void race() {
        List<Car> collect = makeCars(3);
        Cars cars = new Cars(collect);

        RacingGame racingGame = new RacingGame(4, movableStrategy);
        racingGame.race(cars);

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(new Position(1));
        }
    }

    @DisplayName("경주 종료 테스트")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource({"4,4,true", "3,4,false"})
    void isEnd_True_IfCurrentRoundIsEqualToRoundCount(int repeatCount, int roundCount, boolean expected) {
        List<Car> collect = makeCars(3);
        Cars cars = new Cars(collect);
        RacingGame racingGame = new RacingGame(roundCount, movableStrategy);

        for (int i = 0; i < repeatCount; i++) {
            racingGame.race(cars);
        }

        assertThat(racingGame.isEnd()).isEqualTo(expected);
    }

    private List<Car> makeCars(int carCount) {
        List<Car> collect = IntStream.range(0, carCount).mapToObj(index -> new Car()).collect(Collectors.toList());
        return collect;
    }
}
