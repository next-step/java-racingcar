package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @DisplayName(value = "전진 시도 횟수에 따른 자동차별 전진 테스트, 에러 없이 돌아가는지만 테스트")
    @Test
    void race() {
        // given
        int numberOfParticipationCars = 3;
        int numberOfParticipationTry = 5;

        // when
        Racing.race(numberOfParticipationCars, numberOfParticipationTry);
    }

    @DisplayName(value = "경주할 자동차를 생성한다.")
    @Test
    void createParticipationCars() {
        // given
        int numberOfParticipationCars = 3;

        // when
        List<Car> cars = Racing.createParticipationCars(numberOfParticipationCars);

        // then
        assertThat(cars.size()).isEqualTo(3);
    }
}