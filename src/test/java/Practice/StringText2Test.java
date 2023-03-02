package Practice;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringText2Test {
    @Test
    @DisplayName("특정 문자 추출후 체크")
    public void checkWord() {
        StringText2 stringText2 = new StringText2();

        System.out.println(stringText2.textWord);
        assertThat(stringText2.textWord).isEqualTo('b');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> stringText2.originText.charAt(4));
    }
}