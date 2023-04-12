package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Score oneA = new Score(7);
        Score oneB = new Score(7);
        //when
        //then
        assertThat(oneA).isEqualTo(oneB);
    }

    @DisplayName("다른 Value 를 가진 Score 가 동등성 비교에서 다름을 리턴한다")
    @Test
    public void notEquivalence() {
        //given
        Score oneA = new Score(3);
        Score oneB = new Score(5);
        //when
        //then
        assertThat(oneA).isNotEqualTo(oneB);
    }

    @DisplayName("범위를 초과하는 Score 의 Value 입력시 RuntimeException 을 throw 한다 : -1")
    @Test
    public void outOfDownRangeThrowPlz() {
        //given
        //when
        //then
        assertThatThrownBy(() -> {
            new Score(-1);
        }).isInstanceOf(RuntimeException.class);
    }


    @DisplayName("범위를 초과하는 Score 의 Value 입력시 RuntimeException 을 throw 한다 : 10")
    @Test
    public void outOfUpRangeThrowPlz() {
        //given
        //when
        //then
        assertThatThrownBy(() -> {
            new Score(10);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("전진한다 4인경우")
    @Test
    public void forwardOver4() {
        //given
        int input = 4;
        //when
        Score score = new Score(input);
        //then
        assertEquals("-", score.render());
    }

    @DisplayName("전진한다 5인경우")
    @Test
    public void forwardAt5() {
        //given
        int input = 5;
        //when
        Score score = new Score(input);
        //then
        assertEquals("-", score.render());
    }

    @DisplayName("정지한다 2인경우")
    @Test
    public void stop3() {
        //given
        int input = 2;
        //when
        Score score = new Score(input);
        //then
        assertEquals("", score.render());
    }

    @DisplayName("정지한다 3인경우")
    @Test
    public void stop2() {
        //given
        int input = 3;
        //when
        Score score = new Score(input);
        //then
        assertEquals("", score.render());
    }
}