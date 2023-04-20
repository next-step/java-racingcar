package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racingcar.domain.Car;
import study.racingcar.strategy.CarMoveStrategy;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private CarMoveStrategy carMoveStrategy;

    @BeforeEach
    void setUp() {
        carMoveStrategy = new CarMoveStrategy(new ReturnOnlyRandomNumber(5));
    }

    @DisplayName("숫자를 전달하여 자동차가 정상적으로 움직였는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 6, 5})
    public void Car_move(int games) {

        Car car = new Car(0, "pobbi", carMoveStrategy);

        for(int i = 0; i < games; i++) {
            car.move();
        }

        assertThat(car.currentPosition()).isEqualTo(games);
    }

    @DisplayName("자동차 이름은 5글자를 넘을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"bbororo","jaewon","tester"})
    public void Car_isMoreThanFiveLength(String name) {

        assertThatThrownBy(() -> new Car(0, name, carMoveStrategy))
                .isInstanceOf(InputMismatchException.class);
    }

    @DisplayName("자동차의 현재 위치와 최고위치가 같은 경우 TRUE 를 반환한다.")
    @Test
    public void Car_isPosition_TRUE_테스트() {

        Car car = new Car(5, "pobbi", carMoveStrategy);

        assertThat(car.isPosition(5)).isEqualTo(true);
    }

    @DisplayName("자동차의 현재 위치와 최고위치가 다른 경우 FALSE 를 반환한다.")
    @Test
    public void Car_isPosition_FALSE_테스트() {

        Car car = new Car(5, "pobbi", carMoveStrategy);

        assertThat(car.isPosition(10)).isEqualTo(false);
    }
}
