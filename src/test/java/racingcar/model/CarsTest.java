package racingcar.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {
    private static final List<String> CAR_NAMES = Arrays.asList("pobi", "crong", "honux");
    private static Cars cars;

    @BeforeAll
    static void setUp() {
        cars = new Cars(CAR_NAMES);
    }

    @DisplayName("주어진 개수만큼 자동차 객체가 생성되어야한다.")
    @Test
    void cars() {
        assertThat(cars.getCars().size()).isEqualTo(CAR_NAMES.size());
    }

    @DisplayName("시도 후 점수가 달라져야한다.")
    @Test
    void getScores() {
        int before = cars.getCars().get(0).getScore();
        repeatAttempt();
        int after = cars.getCars().get(0).getScore();
        assertThat(after).isNotEqualTo(before);
    }

    @DisplayName("자동차 이름이 5자를 초과하면 에러")
    @Test
    void cars_error() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(Collections.singletonList("pobieee")));
    }

    @DisplayName("우승자가 한명 이상 있어야한다.")
    @Test
    void getWinner() {
        repeatAttempt();
        assertThat(cars.getWinners()).isNotEmpty();
    }

    private void repeatAttempt() {
        for (int i = 0; i < 5; i++) {
            cars.attempt();
        }
    }

}
