package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.Racing.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    @DisplayName("race 메소드가 반환하는 결과 값의 길이는 파라미터로 들어온 Cars의 carList의 길이와 같아야 한다.")
    void race_result() {
        Cars cars = new Cars(3);
        assertThat(race(cars)).hasSize(cars.carList().size());
    }
}