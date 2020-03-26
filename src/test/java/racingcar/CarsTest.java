package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차의 위치를 비교해서 우승자를 구한다")
    public void getWinnerReturnsNameOfWinner() {
        Car wholeman = new Car("wholeman", 2);
        Car pobi = new Car("pobi", 3);
        Car boorownie = new Car("boorownie", 4);
        Cars cars = new Cars(Arrays.asList(wholeman, pobi, boorownie));

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactly("boorownie");
    }

    @Test
    @DisplayName("우승자는 1명 이상 존재할 수 있다")
    public void getWinnerReturnsMultipleWinners() {
        Car wholeman = new Car("wholeman", 2);
        Car pobi = new Car("pobi", 3);
        Car boorownie = new Car("boorownie", 3);
        Cars cars = new Cars(Arrays.asList(wholeman, pobi, boorownie));

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactly("pobi", "boorownie");
    }
}
