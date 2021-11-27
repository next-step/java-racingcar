package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.dto.CarNames;

import java.util.Arrays;

class CarNamesTest {

    @Test
    @DisplayName("get 메서드는 불변한 컬렉션을 반환한다")
    public void unmodifiableTest() {
        CarNames carNames = new CarNames(Arrays.asList(new String[]{"pobi", "conan", "rian"}));

        Assertions.assertThatThrownBy(() -> {
            carNames.getCarNameGroup().remove(0);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

}
