package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.stretagy.MovingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("우승자가 유일한 경우")
    public void singleWinnerTest() {
        Cars cars = new Cars();
        cars.setUp(List.of("pobi","crong","honux"), new FirstCarWinsStrategy());
        cars.race();

        List<String> winners = cars.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactlyElementsOf(List.of("pobi"));
    }

    @Test
    @DisplayName("우승자가 여럿일 경우")
    public void manyWinnerTest() {
        Cars cars = new Cars();
        cars.setUp(List.of("pobi","crong","honux"), new FirstCarLosesStrategy());
        cars.race();

        List<String> winners = cars.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyElementsOf(List.of("crong", "honux"));
    }

    private static class FirstCarWinsStrategy implements MovingStrategy {
        private boolean flag = true;

        @Override
        public boolean isMoved() {
            if (flag) {
                flag = false;
                return true;
            }
            return false;
        }
    }

    private static class FirstCarLosesStrategy implements MovingStrategy {
        private boolean flag = true;

        @Override
        public boolean isMoved() {
            if (flag) {
                flag = false;
                return false;
            }
            return true;
        }
    }

}