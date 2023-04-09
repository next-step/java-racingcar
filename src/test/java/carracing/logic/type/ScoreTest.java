package carracing.logic.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    @DisplayName("같은 Value 를 가진 Score 가 동등한지를 검증 1 - JCF 사용을 위해 검증")
    @Test
    public void equivalence() {
        //given
        Score oneA = new Score(1);
        Score oneB = new Score(1);
        //when
        //then
        assertThat(oneA).isEqualTo(oneB);
    }

    @DisplayName("같은 Value 를 가진 Score 가 동등한지를 검증 2 - JCF 사용을 위해 검증")
    @Test
    public void equivalence2() {
        //given
        Score oneA = new Score(777);
        Score oneB = new Score(777);
        //when
        //then
        assertThat(oneA).isEqualTo(oneB);
    }
}