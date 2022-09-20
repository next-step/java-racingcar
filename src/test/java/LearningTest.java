import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("학습 테스트 실습")
public class LearningTest {

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 1")
    void stringTest1(){
        // GIVEN
        String input1 = "1,2";
        String input2 = "1";
        String separator = ",";

        // WHEN
        String[] result1 = input1.split(separator);
        String[] result2 = input2.split(separator);

        // THEN
        assertThat(result1).contains("1", "2");
        assertThat(result1).containsExactly("1", "2");

        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 2")
    void stringTest2(){
        // GIVEN
        String input1 = "(1,2)";

        // WHEN
        String result1 = input1.substring(input1.indexOf('1'), input1.indexOf('2') + 1);

        // THEN
        String expectedResult = "1,2";
        assertThat(result1).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 3 - 1")
    void stringTest3(){
        // GIVEN
        String input1 = "abc";

        // WHEN
        char result1 = input1.charAt(0);
        char result2 = input1.charAt(2);
        char result3 = input1.charAt(1);

        // THEN
        char expectedChar1 = 'a';
        char expectedChar2 = 'c';
        char expectedChar3 = 'b';

        assertThat(result2).isEqualTo(expectedChar2);
        assertThat(result3).isEqualTo(expectedChar3);
        assertThat(result1).isEqualTo(expectedChar1);
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 3 - 2")
    void stringTest4(){
        // GIVEN
        String input1 = "abc";

        // WHEN & THEN
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input1.charAt(5);
                }).withMessageMatching("Index : \\d+, Size: \\d+");
    }
}
