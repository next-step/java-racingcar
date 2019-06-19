package racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UtilTest {

    private final String INPUT_STRING = "jojo,mike,brian,cell,chacha";


    @Test
    void splitStringNames() {
        List<String> inputStrings = Util.stringSplitToList(this.INPUT_STRING, ",");
        assertThat(inputStrings).contains("jojo", "mike", "brian", "cell", "chacha");
    }

    @Test
    void joinListString() {
        String joinListString = Util.joinListString(Arrays.asList("jojo", "mike", "brian", "cell", "chacha"), ", ");
        assertThat(joinListString).isEqualTo("jojo, mike, brian, cell, chacha");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10})
    void randomNumber(int bound) {
        int result = Util.randomNumber(bound);
        assertThat(result).isBetween(0, bound-1);
    }
}