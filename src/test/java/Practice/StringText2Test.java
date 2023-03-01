package Practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringText2Test {
    @Test
    @DisplayName("특정 문자 추출후 체크")
    public void checkWord() {
        StringText2 stringText2 = new StringText2();
        System.out.println(stringText2.textWord);
//        Assertions.assertThat(stringText2.textWord).isEqualTo('b');

        // V.해당부분 수행 시 오류 발생. 왜 그럴까? 어떻게 해결 가능할까?
        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> Assertions.assertThat(stringText2.textWord).isEqualTo('b'));
    }

}