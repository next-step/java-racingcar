package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RoundResultTest {

    private final List<CarName> names = List.of(
            new CarName("자동차1"), new CarName("자동차2"), new CarName("자동차3")
    );
    private final CarNames carNames = new CarNames(names);

    @Test
    void 라운드_결과를_저장한다() {
        Cars cars = new Cars(carNames);
        cars.move(() -> true);

        RoundResult roundResult = cars.roundResult();

        assertThat(roundResult.getRoundResult()).hasSize(3);
        assertThat(roundResult.getRoundResult())
                .extracting(carResult -> carResult.name().value())
                .containsExactly("자동차1", "자동차2", "자동차3");
        assertThat(roundResult.getRoundResult())
                .extracting(carResult -> carResult.position().value())
                .containsExactly(1, 1, 1);
    }

    @Test
    void 라운드_내의_우승자를_반환한다() {
        RoundResult roundResult = new RoundResult(List.of(
                new CarResult("자동차1", 5),
                new CarResult("자동차2", 3)
        ));

        assertThat(roundResult.winners()).hasSize(1);
        assertThat(roundResult.winners())
                .extracting(carResult -> carResult.name().value())
                .containsExactly("자동차1");
    }

    @Test
    void 라운드_내의_여러_우승자를_반환한다() {
        RoundResult roundResult = new RoundResult(List.of(
                new CarResult("자동차1", 5),
                new CarResult("자동차2", 5)
        ));

        assertThat(roundResult.winners()).hasSize(2);
        assertThat(roundResult.winners())
                .extracting(carResult -> carResult.name().value())
                .containsExactly("자동차1", "자동차2");
    }
}
