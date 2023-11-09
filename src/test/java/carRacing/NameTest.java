package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    @DisplayName("자동차 이름이 5글자 이상일 경우 에러 발생 확인")
    void 자동차_이름_5글자_초과_에러_확인() {
        String testName = "abcedf";

        assertThatThrownBy(() -> new Name(testName)).isInstanceOf(InputMismatchException.class);

    }

    @Test
    @DisplayName("자동차 이름 객체를 비교 ")
    void equal_확인() {
        Name carName1 = new Name("FuBao");
        Name carName2 = new Name("FuBao");

        assertThat(carName1).isEqualTo(carName2);
    }

}
