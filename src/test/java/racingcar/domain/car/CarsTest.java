package racingcar.domain.car;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarsTest {

    @Test
    @DisplayName("cars 생성자 불변성 보장 테스트")
    void carsConstructorTest() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(new Participant("hong"), new Position(3)));
        Cars cars = new Cars(carList);
        carList.add(new Car(new Participant("bok"), new Position(2)));
        assertThat(cars.getCars()).doesNotContain(new Car(new Participant("bok"), new Position(2)));
    }

    @Test
    @DisplayName("getCars 불변성 보장 테스트")
    void getCarsTest() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(new Participant("hong"), new Position(3)));
        Cars cars = new Cars(carList);

        assertThatThrownBy(() -> cars.getCars().add(new Car(new Participant("bok"), new Position(2))))
            .isInstanceOf(UnsupportedOperationException.class);
    }
}