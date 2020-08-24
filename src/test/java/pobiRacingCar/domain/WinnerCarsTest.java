package pobiRacingCar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerCarsTest {
    @Test
    void create() {
        Winners winners = new Winners(Arrays.asList(new Car("pobi"), new Car("crong")));
        assertThat(winners.createWinnerNames()).isEqualTo("pobi,crong");
    }
}
