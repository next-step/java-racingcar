package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    @DisplayName("입력한 수 만큼의 자동차를 생성한다.")
    void 자동차_생성() {
        Race race = new Race();
        race.createCars(3);
        assertThat(race.getCars()).hasSize(3);
    }

}
