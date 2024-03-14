package carRacingWinner.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingWinnerTest {

    @Test
    @DisplayName("이름 글자수")
    public void nameLength() {

        String name = "dongwon";
        assertThat(nameLength(name)).isEqualTo(false);
    }

    private boolean nameLength(String name) {
        return name.length() <= 5;
    }
}