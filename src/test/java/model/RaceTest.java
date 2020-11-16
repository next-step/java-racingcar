package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private Race race;

    @BeforeEach
    void setUp () {
        race = new Race();
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void createCars () {
        race.createCars("test, abc, hyeon");
        Race race1 = new Race();
        race1.createCars("test, abc, hyeon");
        assertThat(race).isEqualTo(race1);
    }
}
