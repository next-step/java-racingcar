package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class StringAddCalTest {

    private StringAddCal stringAddCal;

    @BeforeEach
    void setUp() {
        stringAddCal = new StringAddCal();
    }


    @ParameterizedTest
    @NullAndEmptySource
    public void stringAdd_null_또는_빈문자(String input) {
        int result = stringAddCal.stringAdd(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void stringAdd_숫자하나() throws Exception {
        int result = stringAddCal.stringAdd("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void stringAdd_숫자두개() {
        int result = stringAddCal.stringAdd("1,2");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    public void stringAdd_쉼표_또는_콜론_구분자(String input) {
        int result = stringAddCal.stringAdd(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void stringAdd_custom_구분자() {
        int result = stringAddCal.stringAdd("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1:-2:3", "1,2:-3"})
    public void stringAdd_negative(String input) {
        assertThatThrownBy(() -> {
            stringAddCal.stringAdd(input);
        }).isInstanceOf(RuntimeException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    public void getDefaultStringTest(String input) {
        assertThat(stringAddCal.getDefaultString(input)).isEqualTo(new String[]{"1", "2", "3"});
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//#\n1#2#3"})
    public void getCustomStringTest(String input) {
        assertThat(stringAddCal.getSlashString(input)).isEqualTo(new String[]{"1", "2", "3"});
    }

}