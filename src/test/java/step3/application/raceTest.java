package step3.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class raceTest {

    private Race race;

    @BeforeEach
    public void setUp() {
        race = new Race();
    }

    @Test
    void 입력받은_대수만큼_차량을_생성() {
        race.createCars(5);
        Assertions.assertThat(race.countRacingCar()).isEqualTo(5);
    }
}