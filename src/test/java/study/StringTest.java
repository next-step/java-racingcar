package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//
//        요구사항 1
//        "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
//        "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
//        힌트
//        배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
//        배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
//        요구사항 2
//        "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
//        요구사항 3
//        "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
//        String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
//        JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
public class StringTest {

    @DisplayName("split을 이용한 ','를 기준으로 문자열 나누기")
    @Test
    void splitTest() {
        String[] splitText = "1,2".split(",");
        String[] splitText2 = "1".split(",");

        Assertions.assertThat(splitText).containsExactly("1","2");
        Assertions.assertThat(splitText2).containsExactly("1");
    }

    @DisplayName("맨앞과 맨뒤 괄호 지우기")
    @Test
    void deleteBracketTest() {
        String text = "(1,2)";

        text = text.substring(1, text.length()-1);

        Assertions.assertThat(text).isEqualTo("1,2");
    }

    @DisplayName("charAt을 활용한 원하는 문자 꺼내오기(에러처리도 추가)")
    @Test
    void charAtTest() {
        String text = "abc";

        char firstText = text.charAt(0);

        Assertions.assertThat(firstText).isEqualTo('a');

        try {
            char errorText = text.charAt(3);
        } catch (StringIndexOutOfBoundsException e) {
            throw e;
        }
    }


}
