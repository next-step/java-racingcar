package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaceTest {


    @Test
    void 자동차_경주_결과_테스트() {
        Race race = new Race(3, 5, new AlwaysMovingRule());
        race.play();
        ScoreBoard scoreBoard = race.result();
        assertThat(scoreBoard).isEqualTo(
                new ScoreBoard(
                        List.of(
                                new RaceResult(
                                        List.of(1, 1, 1)
                                ),
                                new RaceResult(
                                        List.of(2, 2, 2)
                                ),
                                new RaceResult(
                                        List.of(3, 3, 3)
                                ),
                                new RaceResult(
                                        List.of(4, 4, 4)
                                ),
                                new RaceResult(
                                        List.of(5, 5, 5)
                                )
                        )
                )
        );
    }

}