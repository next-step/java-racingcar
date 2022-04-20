package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceConditionTest {
    @Test
    void 설정된_경주환경의_유효범위_확인() {
        RaceCondition raceCondition = new RaceCondition();
        assertThat(raceCondition.generateCondition()).isBetween(0, 9);
    }
}