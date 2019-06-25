package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    void 전부_같은_위치이면_모두_우승자() {
        String carNameString = "pobi,crong,honux";
        Cars cars = new Cars(new CarNames(carNameString));

        GameResult gameResult = new GameResult(cars);
        assertThat(gameResult.getWinner()).isEqualTo(carNameString);
    }
}
