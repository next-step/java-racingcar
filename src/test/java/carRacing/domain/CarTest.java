package carRacing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("test");
    }

    @Test
    @DisplayName("자동차 인스턴스를 생성할 수 있다")
    void constructorCreatesNewCar() {
        assertThat(car.getScore()).isZero();
        Car updatedCar = new Car(car);
        assertThat(updatedCar.getScore()).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:0",
            "2:0",
            "3:0",
            "4:1",
            "5:1",
            "6:1",
            "7:1",
            "8:1",
            "9:1"}, delimiter = ':')
    @DisplayName("자동차가 지나간 거리를 구할 수 있다")
    void toStringGetsTraces(int fixedPercentage, int expectedScore) {
        Car updatedCar = car.raceOrStay(car, fixedPercentage);
        assertThat(updatedCar.getScore()).isEqualTo(expectedScore);
    }

}