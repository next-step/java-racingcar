package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@DisplayName("Cars 일급 컬렉션 테스트")
public class CarsTest {

    @Test
    @DisplayName("ArrayList 생성시 null값이 들어오면 NullPointerException이 발생한다.")
    void arrayListNullTest() {
        ArrayList<Car> emptyCars = null;
        Assertions.assertThatThrownBy(() -> new ArrayList<>(emptyCars))
                .isInstanceOf(NullPointerException.class);
    }
}
