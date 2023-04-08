package carracing.race.logic.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    @DisplayName("")
    @Test
    public void equilty() {
        //given
        Score oneA = new Score(1);
        Score oneB = new Score(1);
        //when
        //then
        assertThat(oneA).isEqualTo(oneB);
    }
}