package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @DisplayName("경기용 차가 N대 준비된다.")
    @Test
    void numberOfCars() {
        final List<String> namesOfCars = getDefaultNamesOfCars();
        final Game game = new Game(NumberOfRound.of(5), getDefaultRule(), namesOfCars);

        assertThat(game.getCars().numberOfCars()).isEqualTo(namesOfCars.size());
    }

    GameRule getDefaultRule() {
        return () -> true;
    }

    List<String> getDefaultNamesOfCars() {
        return Arrays.asList("solar", "holar", "cola");

    }
}
