package RacingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UtilTest {

    private final String INPUT_STRING = "jojo,mike,brian,cell,chacha";

    private Util util;

    @BeforeEach
    void setUp() {
        util = new Util();
    }

    @Test
    void splitStringNames() {
        List<String> inputStrings = util.stringSplitToList(this.INPUT_STRING, ",");
        assertThat(inputStrings).contains("jojo", "mike", "brian", "cell", "chacha");
    }

    @Test
    void joinListString() {
        String joinListString = util.joinListString(Arrays.asList("jojo", "mike", "brian", "cell", "chacha"), ", ");
        assertThat(joinListString).isEqualTo("jojo, mike, brian, cell, chacha");
    }
}