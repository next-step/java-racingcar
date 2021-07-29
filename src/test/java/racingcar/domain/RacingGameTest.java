package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {
    private MovableStrategy movableStrategy = () -> true;

    @DisplayName("생성 시 자동차 대수 또는 라운드 수가 0 이하일 경우 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource({"0, 5", "3, 0", "0, 0"})
    void create_ThrowsIllegalArgumentException_IfCarCountOrRoundCountUnderOne(int carCount, int roundCount) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RacingGame(carCount, roundCount, movableStrategy));
    }

    @DisplayName("생성")
    @Test
    void create() {
        int carCount = 3;
        RacingGame racingGame = new RacingGame(carCount, 3, movableStrategy);
        Cars cars = racingGame.getCars();
        assertThat(cars.getCars()).hasSize(carCount);
    }

    @DisplayName("경주")
    @Test
    void race() {
        RacingGame racingGame = new RacingGame(3, 4, movableStrategy);
        racingGame.race();

        Cars cars = racingGame.getCars();
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(new Position(1));
        }
    }

    @DisplayName("경주 종료 테스트")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource({"4,4,true", "3,4,false"})
    void isEnd_True_IfCurrentRoundIsEqualToRoundCount(int repeatCount, int roundCount, boolean expected) {
        RacingGame racingGame = new RacingGame(3, roundCount, movableStrategy);

        for (int i = 0; i < repeatCount; i++) {
            racingGame.race();
        }

        assertThat(racingGame.isEnd()).isEqualTo(expected);
    }
}
