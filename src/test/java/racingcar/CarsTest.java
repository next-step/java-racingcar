package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarsTest {

    @Test
    @DisplayName("position이 가장 높은 자동차들을 찾아야 한다")
    void getWinnerCarNames() {
        String winnerCar = Cars.of(List.of(
                new Car(3, "pobi"),
                new Car(2, "crong")
        )).getWinnerCarNames();
        Assertions.assertThat(winnerCar).isEqualTo("pobi");

        String winnerCars = Cars.of(List.of(
                new Car(1, "pobi"),
                new Car(1, "crong"),
                new Car(0, "honux")
        )).getWinnerCarNames();
        Assertions.assertThat(winnerCars).isEqualTo("pobi, crong");
    }

    @Test
    @DisplayName("자동차들의 현재 상태를 출력해야 한다")
    void getRaceStatusStringTest() {
        String raceStatus = Cars.of(List.of(
                new Car(3, "pobi"),
                new Car(2, "crong")
        )).getRaceStatusString();
        Assertions.assertThat(raceStatus).isEqualTo("pobi : ---\ncrong : --\n");
    }

    @Test
    @DisplayName("우승자가 결정되었을 때에는 더 이상 움직일 수 없어야 한다")
    void cannotMoveWhenWinnersAlreadyExists() {
        Cars cars = Cars.of(List.of(
                new Car(3, "pobi"),
                new Car(2, "crong")
        ));
        cars.getWinnerCarNames();
        Assertions.assertThatThrownBy(() -> cars.moveAll(new AlwaysMoveStrategy()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("우승자가 이미 결정되었습니다.");
    }
}
