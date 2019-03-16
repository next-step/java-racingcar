package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarResultTest {
    @Test
    public void check_car_result_created() {
        Car car = new MockCar("a");
        CarResult carResult = new CarResult(car);

        assertThat(carResult.getName()).isEqualTo("a");
        assertThat(carResult.getMileage()).isEqualTo(3);
    }

    static class MockCar extends Car{
        public MockCar(String name) {
            super(name);
        }

        @Override
        public Integer getMileage() {
            return 3;
        }
    }
}
