package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;
    @BeforeEach
    void setup(){
        car =  new Car( "Morris");
    }


    @DisplayName(" 한번 시도 했을경우  ")
    @ParameterizedTest
    @CsvSource( value = {"2,0", "4,1", "9,1"}, delimiter = ',')
    void run( String meter, String resultMeter) {
            assertThat(car.run(Integer.parseInt(meter))).isEqualTo(Integer.parseInt(resultMeter));
    }

    @DisplayName(" 두 번 시도 했을 경우")
    @Test
    void secondTryRun(){
        int firstTime = car.run(2);
        int secondTime = car.run(7);
        assertThat(car.totalMeter()).isEqualTo(1);
    }


    @Test
    void inValidNumberRunTest() {
        int invalidRunNumber = 3;
        int validRunNumber = 5;
        assertAll(
                ()->assertThat(car.run(invalidRunNumber)).isEqualTo(0),
                ()->assertThat(car.run(validRunNumber)).isEqualTo(1)
        );
    }
}