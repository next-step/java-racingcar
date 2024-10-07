package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.AttemptResult;
import racingcar.mock.TestRandomHolder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("우승한 자동차들을 가져온다.")
    void getWinners() {
        Cars cars = new Cars(List.of(new Car(0, "pobi"), new Car(1, "hoya"), new Car(1, "catsb")));
        List<String> winners = cars.getWinners();
        assertThat(winners).isEqualTo(List.of("hoya", "catsb"));
    }

    @Test
    @DisplayName("자동차들의 시도 결과를 가져온다.")
    void getAttemptResult() {
        Cars cars = new Cars(List.of(new Car(0, "pobi"), new Car(1, "hoya"), new Car(1, "catsb")));
        AttemptResult attemptResult = cars.getAttemptResult(new FourOrMore(new TestRandomHolder(4)));
        assertThat(attemptResult).isEqualTo(new AttemptResult(List.of(new Car(1, "pobi"), new Car(2, "hoya"), new Car(2, "catsb"))));
    }
}