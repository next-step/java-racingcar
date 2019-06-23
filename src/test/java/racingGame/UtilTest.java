package racingGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UtilTest {

    @Test
    void splitStringNames() {
        String INPUT_STRING = "jojo,mike,brian,cell,chacha";
        List<String> inputStrings = Util.stringSplitToList(INPUT_STRING, ",");
        assertThat(inputStrings).contains("jojo", "mike", "brian", "cell", "chacha");
    }

    @Test
    void joinListString() {
        String joinListString = Util.joinListString(Arrays.asList("jojo", "mike", "brian", "cell", "chacha"), ", ");
        assertThat(joinListString).isEqualTo("jojo, mike, brian, cell, chacha");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void randomNumber(int bound) {
        int result = Util.randomNumber(bound);
        assertThat(result).isBetween(0, bound - 1);
    }

    @Test
    void stringNameIsEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Util.stringName(""));
    }

    @Test
    void stringNameIsNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Util.stringName(null));
    }
}