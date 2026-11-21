package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {
    @Test
    @DisplayName("입력한 이름으로 자동차들을 생성한다")
    void createCarsByNames() {
        Cars cars = new Cars(List.of("pobi", "conan"));

        assertThat(cars.getStatuses())
                .containsExactly(new CarStatus("pobi", 0), new CarStatus("conan", 0));
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 IllegalArgumentException")
    void canNotHaveDuplicateNames() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(List.of("pobi", "conan", "pobi")))
                .withMessage("duplicate name is not allowed [pobi]");
    }

    @Test
    @DisplayName("모든 자동차가 생성된 숫자로 한 번씩 전진을 판단한다")
    void moveAllCars() {
        Cars cars = new Cars(List.of("pobi", "conan"));

        cars.move(() -> 4);

        assertThat(cars.getStatuses())
                .containsExactly(new CarStatus("pobi", 1), new CarStatus("conan", 1));
    }

    @Test
    @DisplayName("가장 멀리 간 자동차가 우승자다")
    void findWinner() {
        Cars cars = new Cars(List.of("pobi", "conan", "crong"));
        NumberGenerator onlySecondMoves = new NumberGenerator() {
            private int count = 0;

            @Override
            public int generate() {
                count++;
                if (count == 2) {
                    return 4;
                }
                return 3;
            }
        };

        cars.move(onlySecondMoves);

        assertThat(cars.getWinners()).containsExactly("conan");
    }

    @Test
    @DisplayName("가장 멀리 간 자동차가 여럿이면 모두 우승자다")
    void findMultipleWinners() {
        Cars cars = new Cars(List.of("pobi", "conan", "crong"));
        NumberGenerator exceptSecondMoves = new NumberGenerator() {
            private int count = 0;

            @Override
            public int generate() {
                count++;
                if (count == 2) {
                    return 3;
                }
                return 4;
            }
        };

        cars.move(exceptSecondMoves);

        assertThat(cars.getWinners()).containsExactly("pobi", "crong");
    }
}
