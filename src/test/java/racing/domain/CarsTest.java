package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.utils.DiceWithInput;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(0);
        }

    }

    @DisplayName("DiceWithInput을 사용, 4이상일때")
    @Test
    public void playGameGreater() {
        cars.playGame(new DiceWithInput(4));
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @DisplayName("승자가 중복일때 우승자 정보 반환")
    @Test
    public void getWinnerMulti() {

        int[] positionList = {1, 3, 3};
        Cars cars = new Cars(nameList, positionList);

        List<String> winner = cars.getWinner();
        assertThat(winner).contains("SOO", "RAM");
    }

    @DisplayName("승자가 한명일때 우승자 정보 반환")
    @Test
    public void getWinnerOnlyOne() {

        int[] positionList = {1, 3, 2};

        Cars cars = new Cars(nameList, positionList);
        List<String> winner = cars.getWinner();
        assertThat(winner).contains("SOO");
    }

    @DisplayName("position이 null값일때 에러 발생")
    @Test
    public void constructorWithPositionNull() {

        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(nameList, null));
    }

    @DisplayName("name이 null값일때 에러 발생")
    @Test
    public void constructorWithNamesNull() {

        int[] positionList = {1, 2, 3};
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(null, positionList));
    }

    @DisplayName("namelist배열과 position배열 사이즈가 다를때 에러발생")
    @Test
    public void constructorWithlistSizeNotEqual() {

        int[] threeSizePositons = {1, 2, 3};
        String[] twoSizeNames = {"a", "b"};
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(twoSizeNames, threeSizePositons));
    }

}