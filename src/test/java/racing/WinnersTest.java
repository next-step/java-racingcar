package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Winners;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnersTest {

    @DisplayName("우승자 목록을 전달하면 우승자 객체를 생성한다.")
    @Test
    void createWinnersTest() {
        List<String> winnerList = List.of("김일번", "김이번", "김삼번");
        Winners winners = new Winners(winnerList);

        assertThat(winners.getWinners()).isEqualTo(winnerList);
    }

    @DisplayName("빈 우승자 목록을 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void createWinnersTestException() {
        assertThatThrownBy(() -> new Winners(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("우승자는 최소 1명 이상이여야합니다.");
    }
}
