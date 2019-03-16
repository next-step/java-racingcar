package racingcar.domain.car;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRegistrationTest {

    @Test
    public void 차량등록() {

        CarRegistration carRegistration = new CarRegistration();

        String[] racers = {"po","jo","jay"};
        List<Car> cars = carRegistration.register(racers);

        assertThat(cars.get(0).getName()).isEqualTo("po");
        assertThat(cars.get(1).getName()).isEqualTo("jo");
        assertThat(cars.get(2).getName()).isEqualTo("jay");

    }
}