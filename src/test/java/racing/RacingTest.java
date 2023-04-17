package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @DisplayName("3단계 - 자동차 경주 - 레이싱 객체가 생성되는지 확인")
    @Test
    void create_racing() {
        int leftMatchCounts = 0;
        List<Car> cars = Collections.singletonList(new Car());
        Racing racing = new Racing(leftMatchCounts, cars);
        assertThat(racing).isNotNull();
    }
}
