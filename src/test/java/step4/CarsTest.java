package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;
    private Cars positionCars;
    private String[] nameList = {"HO", "SOO", "RAM"};
    private int[] positionList = {3,3,5};

    @BeforeEach
    public void setUp() {
        cars = new Cars(nameList);
        positionCars = new Cars(nameList,positionList);

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

    @DisplayName("모두가 0일때 승자 출력")
    @Test
    public void getWinner() {
        List<String> winner = cars.getWinner();
        assertThat(winner.size()).isEqualTo(3);
    }

    @DisplayName("포지션이 각자 다를때 출력")
    @Test
    public void getWinnerPostionSet(){
        List<String> winner = positionCars.getWinner();
        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner).contains("RAM");
    }
}