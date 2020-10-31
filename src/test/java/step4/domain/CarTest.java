package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {


    private MoveStrategy moveStrategy;


    @Test
    @DisplayName("전략에 따라 차가 무조건 움직이는지 확인한다.")
    void mustMoveCar() {
        //given
        moveStrategy = new MustMoveStrategy();
        Car car = new Car("Wani");
        //when
        car.move(moveStrategy);
        //then
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전략에 따라 차가 안움직이는지 확인한다.")
    void notMoveCar() {
        //given
        moveStrategy = new NotMoveStrategy();
        Car car = new Car("Wani");
        //when
        car.move(moveStrategy);
        //then
        assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("움직임 횟수에 따라 차의 포지션을 맞춥니다.")
    void moveCarGetPosition(int moveCount) {
        //given
        moveStrategy = new MustMoveStrategy();
        Car car = new Car("Wani");
        //when
        for (int i = 0; i < moveCount; i++) {
            car.move(moveStrategy);
        }
        //then
        assertThat(car.getCarPosition()).isEqualTo(moveCount);
    }


}