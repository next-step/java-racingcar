package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racingcar.domain.Car;
import study.racingcar.strategy.CarMoveStrategy;
import study.racingcar.util.RandomNumber;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("숫자를 전달하여 자동차가 정상적으로 움직였는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 5})
    public void Car_move(int games) {

        Car car = new Car(0, "pobbi", new CarMoveStrategy(new RandomNumber()));

        for(int i = 0; i < games; i++) {
            car.move();
        }

        assertThat(car.currentPosition()).isBetween(0, games);
    }

    @DisplayName("자동차 이름은 5글자를 넘을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"bbororo","jaewon","tester"})
    public void Car_isMoreThanFiveLength(String name) {

        assertThatThrownBy(() -> new Car(0, name, new CarMoveStrategy(new RandomNumber())))
                .isInstanceOf(InputMismatchException.class);
    }

}
