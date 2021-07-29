package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarLocationTest {

    @Test
    @DisplayName("생성자 테스트")
    void carLocationTest() {
        CarLocation carLocation = new CarLocation();

        assertThat(carLocation.equals(new CarLocation(0))).isTrue();

        CarLocation carLocation2 = new CarLocation(10);

        assertThat(carLocation2.equals(new CarLocation(10))).isTrue();
    }

    @Test
    @DisplayName("progress 메소드를 통해서 값이 1만큼 증가하는지 테스트")
    void progressTest() {
        CarLocation carLocation = new CarLocation();

        carLocation = carLocation.progress();

        assertThat(carLocation.equals(new CarLocation(1))).isTrue();
    }
}
