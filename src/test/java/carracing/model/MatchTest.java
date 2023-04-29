package carracing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MatchTest {

    @DisplayName("우승자는 여러명일 수 있다")
    @Test
    public void multiWinner() {
        //given
        Racer mika = new Racer("mika", List.of(7, 7, 7));
        Racer mj = new Racer("mj", List.of(7, 7, 7));
        Racer oasis = new Racer("oasis", List.of(7, 7, 7));
        int answer = 3;
        Match match = new Match();
        //when
        match.addRacer(mika);
        match.addRacer(mj);
        match.addRacer(oasis);
        //then
        assertThat(match.winnerDisplay().participateCount()).isEqualTo(answer);
    }

}