package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    @DisplayName("[성공] 자동차 경주의 최종 우승자가 한명인 경우 한명의 이름만 반환한다.")
    void 자동차_경주_우승자() {
        // Given
        Cars cars = new Cars(
                new Car(new Distance(3), new Name("pobi")),
                new Car(new Distance(2), new Name("crong")),
                new Car(new Distance(1), new Name("honux"))
        );

        // When
        Winners winners = new Winners();
        Names winnerNames = winners.who(cars);

        assertThat(winnerNames.get()).containsExactlyInAnyOrder(new Name("pobi"));
    }

    @Test
    @DisplayName("[성공] 자동차 경주의 최종 우승자가 여러명인 경우 여러개의 이름을 반환한다.")
    void 자동차_경주_다수_우승자() {
        // Given
        Cars cars = new Cars(
                new Car(new Distance(3), new Name("pobi")),
                new Car(new Distance(3), new Name("crong")),
                new Car(new Distance(1), new Name("honux"))
        );

        // When
        Winners winners = new Winners();
        Names winnerNames = winners.who(cars);

        assertThat(winnerNames.get()).containsExactlyInAnyOrder(new Name("pobi"), new Name("crong"));
    }
}
