package race.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    @DisplayName("최종 우승자가 정상적으로 구해지는지 확인")
    void CalculateMaxPosition() {
        String[] carNames = {"aaa", "bbb", "ccc"};
        Cars cars = new Cars(carNames);

        cars.getCars().get(0).move(5); // aaa position 1
        cars.getCars().get(1).move(4); // bbb position 1
        cars.getCars().get(2).move(3); // ccc position 0

        Winners winners = new Winners(cars);
        String result = winners.getWinners();
        System.out.println(result);

        assertThat(result).contains("aaa", "bbb");
        assertThat(result).doesNotContain("ccc");
    }
}