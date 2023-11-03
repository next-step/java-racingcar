package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car car;
    private final int DEFULT_POSITION = 0;

    public void setUp(int position) {
        this.car = new Car(position);
    }

    @DisplayName("자동차가 움직이는지 테스트")
    @Test
    public void move() {
        //given
        setUp(DEFULT_POSITION);
        int moveNumber = 4;
        //when
        car.move(moveNumber);
        //then
        assertThat(car.position()).isEqualTo(1);
    }

    @DisplayName("자동차가 멈추는지 테스트")
    @Test
    public void stop() {
        //given
        setUp(DEFULT_POSITION);
        int moveNumber = 3;
        //when
        car.move(moveNumber);
        //then
        assertThat(car.position()).isEqualTo(0);
    }
}
