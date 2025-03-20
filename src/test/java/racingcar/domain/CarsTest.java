package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.AlwaysMoveStrategy;

import java.util.List;

public class CarsTest {

    @Test
    @DisplayName("position이 가장 높은 자동차들을 찾아야 한다")
    void getWinnerCarNames() {
        List<Name> winnerCar = Cars.of(List.of(
                new Car(Position.of(3), Name.of("pobi")),
                new Car(Position.of(2), Name.of("crong"))
        )).getWinnerCarNames();
        Assertions.assertThat(winnerCar.size()).isEqualTo(1);
        Assertions.assertThat(winnerCar.get(0)).isEqualTo(Name.of("pobi"));

        List<Name> winnerCars = Cars.of(List.of(
                new Car(Position.of(1), Name.of("pobi")),
                new Car(Position.of(1), Name.of("crong")),
                new Car(Position.of(0), Name.of("honux"))
        )).getWinnerCarNames();
        Assertions.assertThat(winnerCars.size()).isEqualTo(2);
        Assertions.assertThat(winnerCars.get(0)).isEqualTo(Name.of("pobi"));
        Assertions.assertThat(winnerCars.get(1)).isEqualTo(Name.of("crong"));
    }


    @Test
    @DisplayName("우승자가 결정되었을 때에는 더 이상 움직일 수 없어야 한다")
    void cannotMoveWhenWinnersAlreadyExists() {
        Cars cars = Cars.of(List.of(
                new Car(Position.of(3), Name.of("pobi")),
                new Car(Position.of(2), Name.of("crong"))
        ));
        cars.getWinnerCarNames();
        Assertions.assertThatThrownBy(() -> cars.moveAll(new AlwaysMoveStrategy()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("우승자가 이미 결정되었습니다.");
    }

    @Test
    void of() {
    }

    @Test
    void moveAll() {
    }
}
