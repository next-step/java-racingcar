package car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @ParameterizedTest
    @ValueSource(strings = {"abcd"})
    void 자동차_이름은_5자리를_초과하지않음(String strings) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> new Car(strings));
    }

    @ParameterizedTest
    @ValueSource(ints = 10)
    void 원하는_수_사이의_랜덤_수를_생성한다(Integer ints) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Boolean numberCheck = number.contains(RandomNumber.getRandomNumber(ints));
        assertThat(numberCheck).isTrue();
    }
}