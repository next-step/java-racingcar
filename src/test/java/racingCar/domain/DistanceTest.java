package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    Distance distance;

    @BeforeEach
    void setUp() {
        distance = new Distance();
    }

    @DisplayName("거리값 반환 테스트")
    @Test
    void testGetDistance(){
        assertThat(distance.getDistance()).isEqualTo(0);
    }

    @DisplayName("거리값 증가 테스트")
    @Test
    void testAddDistance(){
        assertThat(distance.addDistance().getDistance()).isEqualTo(1);
    }

    @DisplayName("거리값 비교 테스트")
    @Test
    void testIsSameDistance(){
        assertThat(new Distance(5).isSameDistance(5)).isTrue();
        assertThat(new Distance(3).isSameDistance(4)).isFalse();
    }

}