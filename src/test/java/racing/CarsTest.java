package racing;

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

    @DisplayName("DiceWithInput을 사용,  4미만일때 ")
    @Test
    public void playGameLess() {

        cars.playGame(new DiceWithInput(3));
        List<Car> carList = cars.getCars();

        List<Integer> result = new ArrayList<>();
        for (Car car : carList) {
            result.add(car.getPosition());
        }
        assertThat(result).contains(0, 0, 0);
    }

    @DisplayName("DiceWithInput을 사용, 4이상일때")
    @Test
    public void playGameGreater() {
        cars.playGame(new DiceWithInput(4));
        List<Car> carList = cars.getCars();
        List<Integer> result = new ArrayList<>();
        for (Car car : carList) {
            result.add(car.getPosition());
        }
        assertThat(result).contains(1, 1, 1);
    }

    @DisplayName("승자가 중복일때 우승자 정보 반환")
    @Test
    public void getWinnerMulti() {

        int[] positionList = {1,3,3};
        Cars cars = new Cars(nameList, positionList);

        List<String> winner = cars.getWinner();
        assertThat(winner).contains("SOO","RAM");
    }

    @DisplayName("승자가 한명일때 우승자 정보 반환")
    @Test
    public void getWinnerOnlyOne() {

        int[] positionList = {1,3,2};

        Cars cars = new Cars(nameList, positionList);
        List<String> winner = cars.getWinner();
        assertThat(winner).contains("SOO");
    }

}