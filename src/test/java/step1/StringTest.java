package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("StringClass 요구사항 1 : 테스트 데이터를 split 메소드를 활용 후 반환값을 검증한다.")
    void stringTest1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
        result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("StringClass 요구사항 2 : 테스트 데이터를 substring 메소드를 활용 후 반환값을 검증한다.")
    void stringTest2() {
        String data = "(1,2)";
        String removeParenthesis = data.substring(data.indexOf("(") +1 , data.indexOf(")"));
        assertThat(removeParenthesis).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringClass 요구사항 3 : 테스트 데이터를 charAt 메소드를 활용 후 예외 결과를 확인한다.")
    void stringTest3() {
        String data = "abc";
        int index = 3;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> {
           data.charAt(index);
        }).withMessage("String index out of range: "+ index);
    }

    @Test
    @DisplayName("StringClass 요구사항 3 번외: 작성자가 원하는 형태로 오류 메세지 정의")
    void stringTest3_Extra() {
        String data = "abc";
        int index = 3;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                try {
                    data.charAt(index);
                }catch (StringIndexOutOfBoundsException e){
                    throw new StringIndexOutOfBoundsException("custom error message");
                }
            }).withMessage("custom error message");
    }

}
