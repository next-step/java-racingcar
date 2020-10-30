package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car ;

    private MoveStrategy moveStrategy;

    @BeforeEach
    void setUp(){
        car = new Car();
    }
    @Test
    @DisplayName("전략에 따라 차가 무조건 움직이는지 확인한다.")
    void mustMoveCar() {
        //given
        moveStrategy = new MustMoveStrategy();
        //when
        car.move(moveStrategy);
        //then
        Assertions.assertThat(car.getCarPosition()).isEqualTo(1);
    }
    @Test
    @DisplayName("전략에 따라 차가 안움직이는지 확인한다.")
    void notMoveCar(){
        //given
        moveStrategy = new NotMoveStrategy();
        //when
        car.move(moveStrategy);
        //then
        Assertions.assertThat(car.getCarPosition()).isEqualTo(0);
    }

}