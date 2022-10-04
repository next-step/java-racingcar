package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayResultTest {

    @Test
    void getValue() {
        PlayResult playResult = new PlayResult(3, "carA");

        assertThat(playResult.getPositionValue()).isEqualTo(3);
        assertThat(playResult.getNameValue()).isEqualTo("carA");
    }

    @Test
    void isPositionEquals() {
        assertThat(new PlayResult(5, "carA").isPositionEquals(new Position(5)))
                .isTrue();
    }

}