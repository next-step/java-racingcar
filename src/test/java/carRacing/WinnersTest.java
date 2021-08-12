package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {

    @Test
    @DisplayName("원하는 포맷의 문자열로 우승자들이 출력되는지 테스트")
    void toStringWinners() {
        Car jae = new Car("jae");
        Car hong = new Car("hong");

        Winners winners = new Winners(Arrays.asList(jae, hong));

        assertThat(winners.toStringWinners()).isEqualTo("jae, hong");
    }
}