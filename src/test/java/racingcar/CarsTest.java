package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@DisplayName("Cars 일급 컬렉션 테스트")
public class CarsTest {

    @Test
    @DisplayName("ArrayList 생성시 null 값이 들어오면 NullPointerException 이 발생한다.")
    void arrayListNullTest() {
        ArrayList<Car> emptyCars = null;
        Assertions.assertThatThrownBy(() -> new ArrayList<>(emptyCars))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Cars 생성시 null 값이 들어오면 NullPointerException 이 발생한다.")
    void nullCarsTest() {
        Assertions.assertThatThrownBy(() -> new Cars(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Cars is null");
    }

    @Test
    @DisplayName("Cars 생성시 빈 리스트가 들어오면 IllegalArgumentException 이 발생한다.")
    void emptyCarsTest() {
        Assertions.assertThatThrownBy(() -> new Cars(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Cars is empty");
    }
}
