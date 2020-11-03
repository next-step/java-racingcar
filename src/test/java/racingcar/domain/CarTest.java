package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car();
    }


    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void moveTest(int randomNumber){
        assertThat(car.move(randomNumber)).isEqualTo("-");
    }
}
