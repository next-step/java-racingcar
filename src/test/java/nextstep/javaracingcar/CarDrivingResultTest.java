package nextstep.javaracingcar;

import nextstep.javaracingcar.domain.CarDrivingResult;
import nextstep.javaracingcar.domain.Distance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarDrivingResultTest {

    @DisplayName("이동 거리가 같은지 확인할 수 있다.")
    @Test
    public void spec01() {
        final Distance ten = new Distance(10);
        final CarDrivingResult carDrivingResult = new CarDrivingResult("aa", ten);
        assertThat(carDrivingResult.equalsDistance(Distance.ONE)).isFalse();
        assertThat(carDrivingResult.equalsDistance(ten)).isTrue();
    }

    @DisplayName("내 거리와 비교해서 더 큰 거리를 반환한다.")
    @Test
    public void spec02() {
        final Distance ten = new Distance(10);
        final CarDrivingResult carDrivingResult = new CarDrivingResult("aa", ten);
        assertThat(carDrivingResult.maxDistance(new Distance(20))).isEqualTo(new Distance(20));
        assertThat(carDrivingResult.maxDistance(new Distance(5))).isEqualTo(ten);
    }
}
