package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void startTest() {
        String[] names = {"광유","재"};
        RacingGame racingGame= new RacingGame(names,3);
        assertThat(racingGame.startRaceAndReduceCount()).isNotNull();
    }

    @DisplayName("생성된 RacingCar를 전진하게 하는 단위 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"광유","재석"} )
    void moveForwardTest(String name) {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar(name));
        for (RacingCar car : cars) {
            car.moveForward();
        }
        assertThat(cars.get(1).getDistance()).isEqualTo(1);
    }

    @DisplayName("입력받은 자동차 대수, 이동횟수로 객체 생성 테스트")
    @Test
    void carCreateTest() {
        String[] carNames = "포비,재석,광유".split(",");
        int moveCount = 5;
        RacingGame racingGame = new RacingGame(carNames, moveCount);
        assertThat(racingGame).isNotNull();
    }

    @DisplayName("입력 받은 문자열을 쉼표(,)로 나누기")
    @Test
    void inputAndSplitTest() {
        String data = "포비,재석,광유";
        assertThat(data.split(",").length).isEqualTo(3);    //길이 확인
        assertThat(data.split(",")).containsExactly("포비","재석","광유");
    }
}
