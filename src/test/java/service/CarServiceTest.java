package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.Cars;

import java.util.List;

class CarServiceTest {

    Cars cars;
    CarService carService;
    private String carsName;
    int moveCarIndex;

    @BeforeEach
    void setUp() {
        carsName = "AAA,BBB,CCC";
        moveCarIndex = 2;
        cars = new Cars(carsName);
        carService = new CarService();
    }

    @Test
    @DisplayName("Cars 객체 생성 확인")
    void readyCars() {
        Cars newCars = carService.readyCars(carsName);
        Assertions.assertThat(newCars).isSameAs(newCars);
    }

    @Test
    @DisplayName("자동차가 random 값에 따라 움직임 확인")
    void carsMove() {
        Cars moveCars = carService.readyCars(carsName);
        int beforeMove = moveCars.getCar(moveCarIndex).getDistance();
        carService.carsMove(moveCarIndex, 5);
        int afterMove = moveCars.getCar(moveCarIndex).getDistance();
        Assertions.assertThat(beforeMove).isNotEqualTo(afterMove);
    }

    @Test
    @DisplayName("가장 멀리 간 거리 확인")
    void findMaxDistance() {
        Cars moveCars = carService.readyCars(carsName);
        carService.carsMove(0, 0);
        carService.carsMove(1, 3);
        carService.carsMove(2, 4);

        int maxDistance = carService.findMaxDistance();
        Assertions.assertThat(maxDistance).isEqualTo(moveCars.getCar(moveCarIndex).getDistance());
    }

    @Test
    void findMaxDistanceCar() {
        Cars moveCars = carService.readyCars(carsName);
        carService.carsMove(0, 0);
        carService.carsMove(1, 5);
        carService.carsMove(2, 2);

        int maxDistance = carService.findMaxDistance();
        List<String> winner = carService.findMaxDistanceCar(maxDistance);
        Assertions.assertThat(winner.size()).isNotEqualTo(0);
    }
}