package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Car;
import step3.model.CarList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarListTest {
    @Test
    @DisplayName("countOfCar을 입력받아 만들어지는 carList 의 여러 car의 position test")
    void carListTest() {
        CarList expectedCarList = new CarList();
        for (int i = 0; i < 5; i++) {
            expectedCarList.getCarList().add(new Car());
        }
        CarList carList = new CarList(5);

        for (int i = 0; i < 5; i++) {
            assertEquals(carList.getCarList().get(i).getPosition(), expectedCarList.getCarList().get(i).getPosition());
        }
    }

    @Test
    @DisplayName("carList가 RandomMoveStrategy에 따라 잘 move하는지 test")
    void randomMoveStrategyTest() {
        CarList carList = new CarList(5);
        carList.movableCarList(() -> true);
        for (int i = 0; i < 5; i++) {
            assertEquals(carList.getCarList().get(i).getPosition(), 1);
        }
    }
}
