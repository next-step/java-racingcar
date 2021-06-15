package calculate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {

    @Test
    void test() {
        Assertions.assertEquals(5, 2 + 3);
        //학습 테스트란 api , 라이브러리 에 대한 테스트
    }

    @Test
    void split로_쉼표나누기() {
        final String[] aaa = "1,2".split(",");
//        for(int i = 0; i < aaa.length; i++){
        assertThat(3 + 2).isEqualTo(5);
//        }
        //학습 테스트란 api , 라이브러리 에 대한 테스트
    }

    @Test
    void split로_가로제거후_반환() {
        String aaa = "(1,2)";
        aaa = aaa.replaceAll("\\(", "");
        aaa = aaa.replaceAll("\\)", "");
        assertThat(aaa).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정갑 가져오")
    void string특정_값_가져오기() {
        String abc = "abc";

        assertThatThrownBy(() -> abc.charAt(4))
            .isInstanceOf(IndexOutOfBoundsException.class);

    }
}
