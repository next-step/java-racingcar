package step3.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void create(){
        car = new Car();
    }

    @DisplayName("자동차 초기값 확인")
    @Test
    void initPositionTest(){
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("차 위치 변경")
    @Test
    void moveCar(){
        int move = 6;
        int notMove = 3;

        car.move(move);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(notMove);
        assertThat(car.getPosition()).isEqualTo(1);
    }


}