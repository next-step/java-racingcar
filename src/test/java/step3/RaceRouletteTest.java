package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class RaceRouletteTest {

    RaceRoulette raceRoulette;

    abstract int max();

    @Test
    @DisplayName("룰렛은 max 이하의 값을 return 한다")
    void shouldAlwaysLessThanMaxValueAndEquals(){
        int loop = 10000;
        while(loop-- > 0){
            assertThat(raceRoulette.spin()).isLessThan(max());
        }
    }

}

class SimpleRaceRouletteTest extends RaceRouletteTest {

    @BeforeEach
    void setUp(){
        raceRoulette = RaceRoulette.simple(max());
    }

    @Override
    int max() {
        return 10;
    }
}