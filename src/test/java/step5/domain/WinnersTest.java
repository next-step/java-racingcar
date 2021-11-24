package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.dto.ResultOfCar;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승한다.")
    void decideWinner() {

        ResultOfCar pobi = new ResultOfCar("pobi", 5);
        ResultOfCar crong = new ResultOfCar("crong", 5);
        ResultOfCar honux = new ResultOfCar("honux", 3);
        List<ResultOfCar> results= Arrays.asList(pobi, crong, honux);

        List<String> winners = Winners.decideWinner(results);

        assertThat(winners).containsExactly("pobi", "crong");
    }


}