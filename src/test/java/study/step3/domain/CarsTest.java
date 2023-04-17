package study.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        String[] carNames = new String[]{"avante", "sonata", "grandeur"};

        cars = new Cars(carNames,
                new LessThanMoveCondition(4, new StaticMove(5)));
    }

    @Test
    void moveForward() throws Exception {
        //given

        //when
        cars.moveForward();

        //then
        assertThat(cars.getCars()
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toList())).containsExactly(Car.GO, Car.GO, Car.GO);
    }

    @Test
    void toPositionOfCars() {
        //given

        //when
        List<Integer> positionOfCars = cars.toPositionOfCars();

        //then
        assertThat(positionOfCars).containsExactly(
                cars.getCars().get(0).getPosition(),
                cars.getCars().get(1).getPosition(),
                cars.getCars().get(2).getPosition());
    }

    @Test
    void toCarNames() {
        //given

        //when
        List<String> positionOfCars = cars.toCarNames();

        //then
        assertThat(positionOfCars).containsExactly(
                cars.getCars().get(0).getName(),
                cars.getCars().get(1).getName(),
                cars.getCars().get(2).getName());
    }

    @Test
    void findWinner() {
        //given

        //when
        cars.moveForward();
        List<String> positionOfCars = cars.findWinner();

        //then
        assertThat(positionOfCars)
                .containsAnyOf("avante", "sonata", "grandeur");
    }
}
