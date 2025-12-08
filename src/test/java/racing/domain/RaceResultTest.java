package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceResultTest {

    @Test
    void 경주_결과에_라운드_결과를_추가할_수_있다() {
        RaceResult raceResult = new RaceResult();

        RoundResult roundResult = new RoundResult(List.of(
                new CarResult(new CarName("자동차1"), new Position(1)),
                new CarResult(new CarName("자동차2"), new Position(2)),
                new CarResult(new CarName("자동차3"), new Position(3))
        ));

        raceResult.addResult(roundResult);
        assertThat(raceResult.getRaceResult()).hasSize(1);
    }

    @Test
    void 마지막_라운드에서_위치가_가장_멀리_간_자동차가_우승자가_된다() {
        RaceResult raceResult = new RaceResult();

        RoundResult round1 = new RoundResult(List.of(
                new CarResult(new CarName("자동차1"), new Position(1)),
                new CarResult(new CarName("자동차2"), new Position(0))
        ));
        RoundResult round2 = new RoundResult(List.of(
                new CarResult(new CarName("자동차1"), new Position(2)),
                new CarResult(new CarName("자동차2"), new Position(1))
        ));

        raceResult.addResult(round1);
        raceResult.addResult(round2);

        List<CarName> winners = raceResult.winners();

        assertThat(winners)
                .extracting(CarName::value)
                .containsExactly("자동차1");
    }

    @Test
    void 가장_멀리_간_자동차가_여러_대라면_모두_우승자이다() {
        RaceResult raceResult = new RaceResult();

        RoundResult onlyRound = new RoundResult(List.of(
                new CarResult(new CarName("자동차1"), new Position(1)),
                new CarResult(new CarName("자동차2"), new Position(1)),
                new CarResult(new CarName("자동차3"), new Position(0))
        ));

        raceResult.addResult(onlyRound);

        List<CarName> winners = raceResult.winners();

        assertThat(winners)
                .extracting(CarName::value)
                .containsExactly("자동차1", "자동차2");
    }
}
