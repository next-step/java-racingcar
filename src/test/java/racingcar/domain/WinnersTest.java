package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    void 우승자_객체_생성() {
        Winners winners = new Winners(Arrays.asList(new Car("애플"), new Car("삼성")));
        assertThat(winners.createWinnerNames()).isEqualTo("애플, 삼성");
    }
}
