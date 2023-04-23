package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.common.RacingCarGame;
import step3.common.vo.Car;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {


    @DisplayName("자동차 대수 만큼 생성 생성")
    @ParameterizedTest
    @ValueSource(ints = {3})
    void createCars(int carNumber) {
        Map<Integer, Car> carMap;
        carMap = RacingCarGame.createCars(carNumber);
        assertThat(carMap).hasSize(3);
    }

    @DisplayName("자동차를 움직일 수 있는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    void canMoveCar(int random) {
        boolean canMove = RacingCarGame.canMove(random);
        if (random > 4) {
            assertThat(canMove).isTrue();
        }
        assertThat(canMove).isFalse();
    }


}
