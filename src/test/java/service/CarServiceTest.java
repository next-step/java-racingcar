package service;

import domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.Cars;

import java.util.List;

class CarServiceTest {

    private String carsName;
    int moveCarIndex;

    @BeforeEach
    void setUp() {
        carsName = "AAA,BBB,CCC";
        moveCarIndex = 2;
    }

    @Test
    @DisplayName("자동차가 random 값이 4이상이면 움직임")
    void carsMove() {
        //given
        CarService carService = new CarService(carsName);
        List<Car> moveCars = carService.getCars();
        int beforeMove = moveCars.get(moveCarIndex).getDistance();

        //when
        carService.carsMove(moveCarIndex, 5);

        //then
        int afterMove = moveCars.get(moveCarIndex).getDistance();
        Assertions.assertThat(beforeMove).isNotEqualTo(afterMove);
    }

    @Test
    @DisplayName("자동차가 random 값이 3이하이면 안움직임")
    void carsNotMove() {
        //given
        CarService carService = new CarService(carsName);
        List<Car> moveCars = carService.getCars();
        int beforeMove = moveCars.get(moveCarIndex).getDistance();

        //when
        carService.carsMove(moveCarIndex, 3);

        //then
        int afterMove = moveCars.get(moveCarIndex).getDistance();
        Assertions.assertThat(beforeMove).isEqualTo(afterMove);
    }

    @Test
    @DisplayName("가장 멀리 간 거리 확인")
    void findMaxDistance() {
        //given
        CarService carService = new CarService(carsName);
        List<Car> moveCars = carService.getCars();

        //when
        carService.carsMove(0, 0);
        carService.carsMove(1, 3);
        carService.carsMove(2, 4);
        int maxDistance = carService.findMaxDistance();

        //then
        Assertions.assertThat(maxDistance).isEqualTo(moveCars.get(moveCarIndex).getDistance());
    }

    @Test
    void findMaxDistanceCar() {
        //given
        CarService carService = new CarService(carsName);
        List<Car> moveCars = carService.getCars();

        //when
        carService.carsMove(0, 0);
        carService.carsMove(1, 5);
        carService.carsMove(2, 2);
        int maxDistance = carService.findMaxDistance();

        //then
        List<String> winner = carService.findMaxDistanceCar(maxDistance);
        Assertions.assertThat(winner.size()).isNotEqualTo(0);
    }
}