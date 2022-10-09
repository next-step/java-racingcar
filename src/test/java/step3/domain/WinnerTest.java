package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.util.Separation;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private Separation separation = new Separation();
    private String input = "pobi,crong,honux";

    @Test
    @DisplayName("우승자 테스트")
    void createWinnerTest() {
        Car car1 = new Car("1번자동차");
        Car car2 = new Car("2번자동차");
        Car car3 = new Car("3번자동차");
        car1.moveOrStop(() -> true);
        car2.moveOrStop(() -> false);
        car3.moveOrStop(() -> false);

        assertThat(new Winner(Arrays.asList(car1, car2, car3))
                .getWinnerList())
                .containsExactly(car1);
    }

}