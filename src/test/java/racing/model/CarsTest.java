package racing.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    private static final String NORMAL_NAME1 = "TEST1";
    private static final String NORMAL_NAME2 = "TEST2";
    private static final String NORMAL_NAME3 = "TEST3";
    private static final int ONE_GO_STRAIGHT = 1;
    private static final int TWO_GO_STRAIGHT = 2;
    private static final int THREE_GO_STRAIGHT = 3;

    @Test
    @DisplayName("레이스 우승자 찾기 Test 우승자는 단 한명")
    void getWinner() {
        final Cars cars = new Cars(
                List.of(
                        new Car(ONE_GO_STRAIGHT, NORMAL_NAME1),
                        new Car(TWO_GO_STRAIGHT, NORMAL_NAME2),
                        new Car(THREE_GO_STRAIGHT, NORMAL_NAME3)
                )
        );
        final Cars winner = new Cars(
                List.of(
                        new Car(THREE_GO_STRAIGHT, NORMAL_NAME3)
                )
        );

        assertThat(cars.getWinner()).isEqualTo(winner);
    }

    @Test
    @DisplayName("레이스 우승자 찾기 Test 우승자는 여러명")
    void getWinners() {
        final Cars cars = new Cars(
                List.of(
                        new Car(ONE_GO_STRAIGHT, NORMAL_NAME1),
                        new Car(TWO_GO_STRAIGHT, NORMAL_NAME2),
                        new Car(TWO_GO_STRAIGHT, NORMAL_NAME3)
                )
        );
        final Cars winners = new Cars(
                List.of(
                        new Car(TWO_GO_STRAIGHT, NORMAL_NAME2),
                        new Car(TWO_GO_STRAIGHT, NORMAL_NAME3)
                )
        );
        assertThat(cars.getWinner()).isEqualTo(winners);
    }
}