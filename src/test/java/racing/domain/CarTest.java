package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    Car car;

    @BeforeEach
    public void before() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"4:true", "3:false", "1:false", "6:true"}, delimiter = ':')
    public void carConstructor(int num, boolean result) {
        Assertions.assertThat(car.isCondition(num)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "4", "2", "6"})
    public void movieTest(int maxNum){
        for (int i=0; i<maxNum; i++) {
            car.move();
        }

        Assertions.assertThat(car.getLocation()).isEqualTo(maxNum);
    }

}
