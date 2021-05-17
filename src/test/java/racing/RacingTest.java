package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private List<Car> cars;
    private Racing racing;

    @BeforeEach
    void set() {
        cars = new ArrayList<>();
        cars.add(new Car("chloe"));
        cars.add(new Car("tt"));
        racing = new Racing(cars);
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

        assertThat(printResult.printWinner(players)).containsExactly("tt","ss");
    }

    @DisplayName("전진하는 조건은 무작위 값이 4 이상일 경우이다.")
    @Test
    void movedTest() {
        racing.moved(4, cars.get(0));
        assertThat(cars.get(0).getMovingRange()).isEqualTo(1);
    }

    @DisplayName("자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.")
    @Test
    void printTest()  {
        Racing racing2 = new Racing("tt,ss", 3);

        assertThat(racing2.race()).containsAnyOf("tt", "ss");
    }
}
