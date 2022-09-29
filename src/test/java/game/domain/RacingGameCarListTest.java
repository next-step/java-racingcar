package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingGameCarListTest {

    @DisplayName("만들 자동차의 대수를 입력하면 리스트에 대수만큼 자동차를 추가한다.")
    @Test
    void makeCars() {
        assertThat(RacingGameCarList.makeRacingGameCars(4).cars().size()).isEqualTo(4);
    }

}
