package racingGame.Business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.Rules;

class CarFactoryTest {
    
    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = new CarFactory();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void carSetTest(int num) {
        assertThatThrownBy(() -> {
            carFactory.createCars(num);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s", "참가시킬 자동차 수 입력이 생략되거나, 0이하");
    }
    @Test
    void carMakeTest() {
        carFactory = new CarFactory();
        assertThat(carFactory.createCars(3).size()).isEqualTo(3);
    }

}