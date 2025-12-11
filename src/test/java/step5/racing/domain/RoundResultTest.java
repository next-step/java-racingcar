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
    }
}
