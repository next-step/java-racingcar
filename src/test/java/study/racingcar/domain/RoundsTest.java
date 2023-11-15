package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import study.racingcar.domain.car.Cars;
import study.racingcar.domain.round.Round;
import study.racingcar.domain.round.Rounds;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundsTest {

    @DisplayName("입력 값만큼 라운드를 생성")
    @ValueSource(ints = {2,3,0,99})
    @ParameterizedTest
    void createRoundList(int count){
        Round round = new Round(new Cars(Collections.emptyList()));
        List<Round> roundList = Collections.nCopies(count, round);
        Rounds rounds = Rounds.from(roundList);
        assertThat(rounds.numberOfRound()).isEqualTo(count);
    }

}
