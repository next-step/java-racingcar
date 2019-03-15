package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarResultTest {
    @Test
    public void check_car_result_created() {
        Car car = new MockCar();
        CarResult carResult = new CarResult(car);

        assertThat(carResult.getName()).isEqualTo("test-car");
        assertThat(carResult.getMileage()).isEqualTo(3);
    }

    static class MockCar extends Car{
        @Override
        public String getName() {
            return "test-car";
        }

        @Override
        public Integer getMileage() {
            return 3;
        }
    }
}
