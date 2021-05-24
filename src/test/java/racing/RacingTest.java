package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @BeforeEach
    void set() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("chloe"));
        cars.add(new Car("tt"));
        Racing racing = new Racing(cars);
    }

    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다.")
    @Test
    void splitTest() {
        String names = "tt,ss";
        Players players = new Players(names);

        List<String> splitNames = players.getCarNames();

        assertThat(splitNames).containsExactly("tt","ss");
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.")
    @Test
    void winner() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("chloe",4));
        cars.add(new Car("tt",5));
        cars.add(new Car("ss",5));

        Players players = new Players(cars);
        PrintResult printResult = new PrintResult();

        assertThat(printResult.setWinner(players)).containsExactly("tt","ss");
    }

    @DisplayName("자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.")
    @Test
    void printTest()  {
        Racing racing = new Racing("tt,ss", 3);
        PrintResult printResult = new PrintResult();

        racing.race();
        assertThat(racing.getWinners()).containsAnyOf("tt","ss");
    }
}
