package step3.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsTest {

    static Cars cars;
    @BeforeAll
    static void create(){
        cars = new Cars();
    }

    @DisplayName("Cars 객체 생성(숫자만큼 Car 객체 소유함)")
    @Test
    void makeCarsTest(){
        cars.makeCars(10);
        assertThat(cars.getCars().size()).isEqualTo(10);
    }

    @DisplayName("차 움직이기")
    @Test
    void moveCarsTest(){
        cars.makeCars(3);

        for (int i = 0; i < 10; i++) {
            cars.moveCars();
        }

        assertThat(cars.getCars())
                .hasSize(3)
                .extracting(Car::getPosition)
                .isNotEqualTo(1);
    }

    @DisplayName("차 생성 안하고 주행시작")
    @Test
    void noCarsStateTest(){
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(
                () -> cars.moveCars()
        ).withMessageContaining("먼저 생성");
    }
}