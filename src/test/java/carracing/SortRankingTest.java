package carracing;

import carracing.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static carracing.utile.SortRanking.sortRanking;
import static org.assertj.core.api.Assertions.assertThat;

public class SortRankingTest {
    @Test
    @DisplayName("자동차 순위 내림차순 정렬 테스트")
    void carSortRanking() {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("kim", 4));
        cars.add(new Car("woo", 2));
        cars.add(new Car("hun", 3));
        cars.add(new Car("lee", 4));

        sortRanking(cars);

        String[] carNames = new String[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            carNames[i] = cars.get(i).getName();
        }
        assertThat(carNames).containsExactly("kim", "lee", "hun", "woo");
    }
}
