package study04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import study04.racing.car.Distance;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class DistanceTest {

    @Test
    @DisplayName("테스트01 - 주행거리 생성 테스트")
    void test01() {
        Distance distance = Distance.createDistance();
        Distance moveDistance = Distance.createDistance(5);

        assertThat(distance.totalDistance()).isEqualTo(1);
        assertThat(moveDistance.totalDistance()).isEqualTo(5);
    }

    @Test
    @DisplayName("테스트02 - 주행거리 변경 테스트")
    void test02() {
        Distance distance = Distance.createDistance();
        distance.addDistance();
        distance.addDistance();
        assertThat(distance.totalDistance()).isEqualTo(3);
        distance.addDistance();
        distance.addDistance();
        distance.addDistance();
        assertThat(distance.totalDistance()).isEqualTo(6);
    }

}
