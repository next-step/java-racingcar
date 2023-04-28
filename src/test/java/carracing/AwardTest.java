package carracing;

import carracing.domain.Award;
import carracing.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static carracing.utile.SortRanking.sortRanking;
import static org.assertj.core.api.Assertions.assertThat;

public class AwardTest {
    private List<Car> cars;

    @BeforeEach
    void createCars() {
        cars = new ArrayList<>();
        cars.add(new Car("kim", 4));
        cars.add(new Car("woo", 2));
        cars.add(new Car("hun", 3));
        cars.add(new Car("lee", 4));
    }

    @Test
    @DisplayName("우승한 자동차들 이름 확인 테스트")
    void getWinnerNames() {
        List<String> winnerNames = Award.getWinner(cars);
        String winners = "";
        for (String winner : winnerNames) {
            winners += winner;
        }
        assertThat(winnerNames).containsExactly("kim", "lee");
    }

}
