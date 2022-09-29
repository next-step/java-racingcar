package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarTest {

    @Mock
    Random random;

    @Test
    @DisplayName("자동차의 시작 위치는 0이다")
    void initPosition() {
        assertThat(new Car().getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 시도 성공 시 position이 1 위치로 변경된다")
    void go_success() {
        when(random.nextInt(anyInt()))
                .thenReturn(9);

        Car car = new Car(random);
        car.go();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 시도 실패시 움직이지 않는다")
    void go_fail() {
        when(random.nextInt(anyInt()))
                .thenReturn(0);

        Car car = new Car(random);
        car.go();

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
