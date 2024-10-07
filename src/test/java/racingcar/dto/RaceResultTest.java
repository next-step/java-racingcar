package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultTest {
    @Test
    @DisplayName("시도 결과들을 반환한다.")
    void formatAttempts() {
        String lineSeparator = System.lineSeparator();
        RaceResult raceResult = new RaceResult(List.of(new AttemptResult(List.of(new Car(0, "pobi"), new Car(1, "catsb"), new Car(2, "hoya")))), List.of());
        assertThat(raceResult.formatAttempts(lineSeparator)).isEqualTo("pobi : " + lineSeparator + "catsb : -" + lineSeparator + "hoya : --" + lineSeparator + lineSeparator);
    }

    @Test
    @DisplayName("우승자 이름들을 합쳐서 반환한다.")
    void joinWinners() {
        RaceResult raceResult = new RaceResult(List.of("pobi", "catsb", "hoya"));
        assertThat(raceResult.joinWinners()).isEqualTo("pobi, catsb, hoya");
    }

    @Test
    @DisplayName("불변성 보장을 위한 방어적 복사 테스트")
    void getter() {
        List<AttemptResult> attemptResults = List.of(new AttemptResult(List.of(new Car(5, "hoya"))));
        List<String> winners = List.of("hoya");
        RaceResult raceResult = new RaceResult(attemptResults, winners);

        raceResult.getAttemptResults().clear();
        raceResult.getWinners().clear();

        assertThat(raceResult.getAttemptResults()).isEqualTo(attemptResults);
        assertThat(raceResult.getWinners()).isEqualTo(winners);
    }
}
