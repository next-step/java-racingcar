package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RoundResultTest {

    private final List<CarName> carNames = List.of(
            new CarName("자동차1"), new CarName("자동차2"), new CarName("자동차3")
    );


    @Test
    void 한_라운드의_결과를_저장한다() {
        Cars cars = new Cars(carNames);
        cars.moveCars(() -> true);

        RoundResult roundResult = cars.roundResult();

        assertThat(roundResult.getRoundResult()).hasSize(3);
        assertThat(roundResult.getRoundResult())
                .extracting(carResult -> carResult.getCarName().value())
                .containsExactly("자동차1", "자동차2", "자동차3");
        assertThat(roundResult.getRoundResult())
                .extracting(carResult -> carResult.getPosition().value())
                .containsExactly(1, 1, 1);
    }
}
