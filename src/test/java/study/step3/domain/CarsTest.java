package study.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            carList.add(new Car(new LessThanMoveCondition(4)));
        }

        cars = new Cars(carList);
    }

    @Test
    void toPositionOfCars() {
        //given
        List<Car> carList = cars.getCars();
        Car avante = carList.get(0);
        Car sonata = carList.get(1);
        Car grandeur = carList.get(2);

        //when
        List<Integer> positionOfCars = cars.toPositionOfCars();

        //then
        assertThat(positionOfCars).containsExactly(
                avante.getPosition(),
                sonata.getPosition(),
                grandeur.getPosition());
    }
}