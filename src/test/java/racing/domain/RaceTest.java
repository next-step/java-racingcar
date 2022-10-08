package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {


    @Test
    void 자동차_경주_결과_테스트() {
        CarFactory carFactory = new CarFactory(new AlwaysMovingStrategy());
        Race race = new Race(carFactory.create("띠띠", "씽씽", "뚜뚜"), 3);
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