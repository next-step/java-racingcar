package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;
    private String[] nameList = {"HO", "SOO", "RAM"};

    @BeforeEach
    public void setUp() {
        cars = new Cars(nameList);
    }

    @DisplayName("DiceWithInput을 사용,  4보다 작을때 ")
    @Test
    public void playGameLess() {

        cars.playGame(new DiceWithInput(3));
        List<Car> carList = cars.getCarList();

        List<Integer> result = new ArrayList<>();
        for (Car car : carList) {
            result.add(car.getPosition());
        }
        assertThat(result).contains(0, 0, 0);
    }

    @DisplayName("DiceWithInput을 사용, 4보다 클때")
    @Test
    public void playGameGreater() {
        cars.playGame(new DiceWithInput(4));
        List<Car> carList = cars.getCarList();
        List<Integer> result = new ArrayList<>();
        for (Car car : carList) {
            result.add(car.getPosition());
        }

        assertThat(result).contains(1, 1, 1);


    }
}