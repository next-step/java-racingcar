package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ui.ResultView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    @DisplayName("입력한 자동차 이름에 맞춰 경주에 참여하는 차 리스트 생성")
    public void createCarTest() {
        List<String> carNameList = Arrays.asList("yuno", "bingb");
        RacingCarGame racingCarGame = new RacingCarGame(carNameList, 0);
        List<Car> carList = racingCarGame.getCarList();

        assertThat(carList).hasSize(2);
    }

    @Test
    @DisplayName("자동차가 전진한만큼 차 위치 출력")
    void resultPathTest() {
        int moveCount = 3;
        Car car = new Car(new FixedGenerator(MovingCondtion.MOVABLE_MIN_VALUE), "test");
        for (int i = 0; i < moveCount; i++) {
            car.tryMove();
        }

        assertThat(ResultView.getPathString(car.getPosition())).isEqualTo("---");
    }
}
