package racingGame.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarFactoryTest {
    
    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = new CarFactory();
    }

    @Test
    void carSetTest() {
        String[] strings = {};
        assertThatThrownBy(() -> {
            carFactory.createCars(strings);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s", "참가시킬 자동차 수 입력이 생략되거나, 0이하");
    }
    @Test
    void carMakeTest() {
        String[] strings = {"pobi", "crong","honux"};
        carFactory = new CarFactory();
        assertThat(carFactory.createCars(strings)).hasSize(strings.length);
    }

}