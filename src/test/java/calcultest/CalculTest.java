package calcultest;

import calcul.Calcul;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculTest {

    private Calcul calcul = new Calcul();

    @Test
    void addTest(){

        assertThat(5).isEqualTo(calcul.add(2, 3));
    }

    @Test
    void subTest(){

        assertEquals(5, calcul.sub(8, 3));
    }

    @Test
    void multiTest(){

        assertEquals(6, calcul.multi(2, 3));
    }

    @Test
    void divisionTest(){

        assertEquals(2, calcul.division(6, 3));
    }

    @ParameterizedTest
    @ValueSource(strings = {"88", " "})
    void nullCheckTest(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            calcul.nullCheck(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void operCheckTest(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            calcul.operCheck(input);
        });
    }
}
