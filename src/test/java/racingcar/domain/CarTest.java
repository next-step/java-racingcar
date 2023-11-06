package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car car;
    private final int DEFAULT_POSITION = 0;
    private final String DEFAULT_CAR_NAME = "pobi";

    public void setUp(int position, String name) {
        this.car = new Car(position, name);
    }

    @DisplayName("자동차 이름4글자 부여")
    @Test
    public void carName() {
        //given
        setUp(DEFAULT_POSITION, DEFAULT_CAR_NAME);
        //when
        //then
        assertThat(car.name()).isEqualTo(DEFAULT_CAR_NAME);
    }

    @DisplayName("자동차가 4이상일때 움직이는지 테스트")
    @Test
    public void move() {
        //given
        setUp(DEFAULT_POSITION, DEFAULT_CAR_NAME);
        int moveNumber = 4;
        //when
        car.move(moveNumber);
        //then
        assertThat(car.position()).isEqualTo(1);
    }

    @DisplayName("자동차가 3이하일때 멈추는지 테스트")
    @Test
    public void stop() {
        //given
        setUp(DEFAULT_POSITION, DEFAULT_CAR_NAME);
        int moveNumber = 3;
        //when
        car.move(moveNumber);
        //then
        assertThat(car.position()).isEqualTo(0);
    }
}
