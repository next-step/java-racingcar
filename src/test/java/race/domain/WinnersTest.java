package race.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    @DisplayName("최종 우승자가 정상적으로 구해지는지 확인")
    void findWinners() {
        String[] carNames = {"aaa", "bbb", "ccc"};
        Cars cars = new Cars(carNames);

        cars.cars().get(0).move(() -> true); // aaa position 1
        cars.cars().get(1).move(() -> true); // bbb position 1
        cars.cars().get(2).move(() -> false); // ccc position 0

        Winners winners = new Winners(cars);
        String result = winners.getWinners();
        System.out.println(result);

        assertThat(result).contains("aaa", "bbb");
        assertThat(result).doesNotContain("ccc");
    }
}