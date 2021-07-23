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
    void getDistanceTest(){
        assertThat(distance.getDistance()).isEqualTo(0);
    }

    @DisplayName("거리값 증가 테스트")
    @Test
    void addDistanceTest(){
        assertThat(distance.addDistance().getDistance()).isEqualTo(1);
    }

}