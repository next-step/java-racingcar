package racegame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGameTest {

    @Test
    void 자동차_생성된지_확인하기() {
        Car carOne = new Car("car1");
        assertThat(carOne).isNotNull();
    }

    @Test
    void 자동차_초기화_확인하기() {
        Car carOne = new Car("car1");
        assertThat(carOne.getGoStep()).isEqualTo(0);
    }

    @Test
    void 자동차움직이는지확인하기() {
        Car carOne = new Car("car1");
        carOne.move();
        carOne.move();
        carOne.move();
        carOne.move();
        assertThat(carOne.getGoStep()).isEqualTo(4);
    }


}
