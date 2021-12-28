import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car = new Car();
    private String carsName;

    @BeforeEach
    void setUp() {
        carsName = "AAA,BBB,CCC";
    }

    @Test
    void splitCarsName() {
        car.splitCarsName(carsName);
        Assertions.assertThat(Car.cars).contains("AAA", "BBB","CCC");
    }

    @Test
    void validateNameLengthCheck() {
        for(int i=0; i<Car.cars.size(); i++){
            String name = Car.cars.get(i);
            car.validateNameLengthCheck(name);
        }
    }

    @Test
    void carsMove() {
        String beforeMoving = Car.carsMoving.get(0);
        car.carsMove(0, 4);
        String afterMoving = Car.carsMoving.get(0);
        Assertions.assertThat(afterMoving).isNotEqualTo(beforeMoving);
    }

    @Test
    void findMaxDistance() {
        car.carsMove(0,0);
        car.carsMove(1,4);
        car.carsMove(2,0);

        int maxDistance = car.findMaxDistance();
        Assertions.assertThat(maxDistance).isNotEqualTo(0);
    }

    @Test
    void findMaxDistanceCar() {
        car.splitCarsName(carsName);
        car.carsMove(0,0);
        car.carsMove(1,4);
        car.carsMove(2,0);

        int maxDistance = car.findMaxDistance();
        car.findMaxDistanceCar(maxDistance);
        Assertions.assertThat(Car.winner.size()).isNotEqualTo(0);
    }

}