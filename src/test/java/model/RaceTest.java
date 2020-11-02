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
    void setCars (int carCount) {
        race.setCars(carCount);
        assertThat(race.getCars().size()).isEqualTo(carCount);
    }


    @ParameterizedTest
    @DisplayName("레이스 시도 횟수 셋팅 테스트")
    @ValueSource(ints = {3, 5})
    void setTryCount (int tryCount) {
        race.setTryCount(tryCount);
        assertThat(race.getTryCount()).isEqualTo(tryCount);
    }
}