package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {


    @BeforeEach
    void setUp() {
        System.out.println("string test setup!");
    }
    /*
        "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 테스트
     */
    @DisplayName("java.lang.String의 split()메소드 테스트")
    @Test
    void splitTest1() {

        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    /*
        "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인하는 테스트
     */
    @DisplayName("java.lang.String의 split()메소드 테스트")
    @Test
    void splitTest2() {

        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    /*
        "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현 & 테스트
     */
    @DisplayName("java.lang.String의 subString()메소드 테스트")
    @Test
    void subStringTest() {

        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    /*
        - "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
          StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        - JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @DisplayName("java.lang.Sring의 charAt() 메소드 IndexOutOfBoundsException 테스트")
    @Test
    void charAtTest() {

        String testString = "randomTestString1234";
        int testStringLen = testString.length();

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    testString.charAt(testStringLen+1);
                });
    }

}
