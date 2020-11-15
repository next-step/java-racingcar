package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private Race race;

    @BeforeEach
    void setUp () {
        race = new Race();
    }

    @ParameterizedTest
    @DisplayName("자동차 생성 테스트")
    @ValueSource(ints = {3, 5})
    void createCars (int carCount) {
        race.createCars(carCount);
        Race race1 = new Race();
        race1.createCars(carCount);
        assertThat(race).isEqualTo(race1);
    }
}
