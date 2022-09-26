package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberTest {

    @Test
    @DisplayName("private 생성자 확인")
    void constructor_is_private() throws NoSuchMethodException {
        Constructor<RandomNumber> constructor = RandomNumber.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    @DisplayName("랜덤 숫자[0~9] 생성")
    void generate_number_between_zero_nine() {
        int result = RandomNumber.generate();
        assertThat(result).isBetween(0, 9);
    }
}
