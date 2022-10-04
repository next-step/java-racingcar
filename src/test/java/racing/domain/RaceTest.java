package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaceTest {


    @Test
    void 자동차_경주_결과_테스트() {
        Race race = new Race(new String[]{"띠띠", "씽씽", "뚜뚜"}, 3, new AlwaysMovingRule());
        race.play();
        ScoreBoard scoreBoard = race.result();
        List<RaceResult> raceResults = scoreBoard.raceResults();
        assertThat(raceResults).isEqualTo(
                List.of(
                        new RaceResult(
                                List.of(
                                        new Record("띠띠", 1),
                                        new Record("씽씽", 1),
                                        new Record("뚜뚜", 1)
                                )
                        ),
                        new RaceResult(
                                List.of(
                                        new Record("띠띠", 2),
                                        new Record("씽씽", 2),
                                        new Record("뚜뚜", 2)
                                )
                        ),
                        new RaceResult(
                                List.of(
                                        new Record("띠띠", 3),
                                        new Record("씽씽", 3),
                                        new Record("뚜뚜", 3)
                                )
                        )
                )
        );
    }

}