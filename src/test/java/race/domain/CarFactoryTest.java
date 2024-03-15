package race.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
    @Test
    void 자동차_리스트_생성() {
        CarFactory carFactory = new CarFactory();
        int carCount = 1;
        List<Car> carList = carFactory.createCars(carCount);
        assertThat(carList).hasSize(1);
    }

}
