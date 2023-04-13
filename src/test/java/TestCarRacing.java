import CarRacing.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCarRacing {

    Racing racing = new Racing();

    @Test
    @DisplayName("4보다 적은 수 입력 시 차량 이동 없음")
    public void drive_less_4() {
        int actual = racing.drive(3);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("4보다 큰 수 입력 시 차량 이동")
    public void drive_more_4() {
        int actual = racing.drive(5);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("4 입력 시 차량 이동")
    public void drive_equal_4() {
        int actual = racing.drive(4);
        assertThat(actual).isEqualTo(1);
    }

}
