package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private final Cars cars = new Cars(new ArrayList<>());

    @Test
    @DisplayName("car 생성 테스트")
    void createCarTest() {
        String[] name = {"jisu","mina","jojo"};
        assertThat(cars.createCar(name)).hasSize(3);
    }
}
