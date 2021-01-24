package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultWinnersTest {

    @DisplayName("승자의 정보가 담긴 리스트를 잘 가져오는지 확인")
    @Test
    void getWinners() {
        List<String> winner = new ArrayList<String>() {{
            add("car1");
            add("car2");
        }};
        ResultWinners resultWinners = new ResultWinners(winner);

        assertThat(resultWinners.getWinners()).isEqualTo(winner);
    }
}