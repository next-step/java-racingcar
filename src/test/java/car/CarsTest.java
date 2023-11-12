package car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private final InputParser inputParser = new InputParser();

    @Test
    public void 자동차_생성_테스트() {
        List<Car> expected = new ArrayList<>();
        expected.add(new Car("pobi"));
        expected.add(new Car("crong"));

        Cars cars = new Cars(inputParser.parseUserInputByDelimiter("pobi,crong"));

        assertThat(cars.getCars()).isEqualTo(expected);
    }

    @Test
    public void 게임_진행_후_단독_우승자_포비_식별_과정_테스트() {

        Cars cars = new Cars(inputParser.parseUserInputByDelimiter("pobi,crong,jun"));
        List<Integer> randomNumbers = Arrays.asList(5, 1, 1);
        cars.playGameByCars(randomNumbers);

        List<String> result = cars.findTiedWinnerCarNames();

        assertThat(result).hasSize(1);
        assertThat(result).containsExactly("pobi");
    }

    @Test
    public void 게임_진행_후_공동_우승자_포비_크롱_식별_과정_테스트() {
        //given
        Cars cars = new Cars(inputParser.parseUserInputByDelimiter("pobi,crong,jun"));
        List<Integer> randomNumbers = Arrays.asList(5, 5, 1);
        cars.playGameByCars(randomNumbers);

        //when
        List<String> result = cars.findTiedWinnerCarNames();

        assertThat(result).hasSize(2);
        assertThat(result).containsExactly("pobi", "crong");
    }
}
