package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.dto.CarData;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승한다.")
    void decideWinner() {

        CarData pobi = new CarData("pobi", 5);
        CarData crong = new CarData("crong", 5);
        CarData honux = new CarData("honux", 3);
        List<CarData> results= Arrays.asList(pobi, crong, honux);

        List<String> winners = Winners.decideWinner(results);

        assertThat(winners).containsExactly("pobi", "crong");
    }


}