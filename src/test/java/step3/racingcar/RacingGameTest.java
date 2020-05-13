package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("차량 대수 Input을 입력받으면 RacingCar 객체를 Input 개수만큼 생성하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 3})
    public void makeRacingCarObjectInAccordanceWithInput(int carCounts) {
        RacingGame racingGame = new RacingGame();
        racingGame.makeRacingCars();
        assertThat(racingGame.getRacingCars().size()).isEqualTo(carCounts);
    }


}
