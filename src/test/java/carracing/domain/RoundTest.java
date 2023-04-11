package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RoundTest {
    @DisplayName("Round 0 는 생성이 불가능하여 Exception 을 throw 한다")
    @Test
    public void round0NG() {
        //given
        //when
        //then
        assertThatThrownBy(() -> {
            new Round(0,Round.emptyScores);
        }).isInstanceOf(RuntimeException.class)
            .hasMessageContaining("라운드는 1부터 시작하므로 항상 1 이상입니다");
    }

    @DisplayName("Round 가 1 이상의 수부터 생성할수있다")
    @Test
    public void roundOK() {
        //given
        //when
        new Round(1,Round.emptyScores);
        new Round(11,Round.emptyScores);
        new Round(111,Round.emptyScores);
        new Round(1111,Round.emptyScores);
        new Round(11111,Round.emptyScores);
        new Round(787,Round.emptyScores);
        //then
    }

}