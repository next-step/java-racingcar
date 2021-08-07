package edu.nextstep.racingcarwinner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 이름을 입력 받아 Car 생성")
    void create() {
        // given
        String name = "younhwan";
        // when
        Car car = new Car(name);
        // then
        assertThat(car).isEqualTo(new Car("younhwan",0));
    }

    @Test
    @DisplayName("이동 명령어 실행 시 이동 여부 확인")
    void move() {
        // given
        Car car = new Car("car");
        // when
        car.move();
        // then
        assertThat(car).isEqualTo(new Car("car", 1));
    }
}
