import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    /**
     * 요구사항 1
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    @DisplayName("요구사항1")
    void stringTestNo1(){
        String sampleText = "1,2";
        String[] splitedText = sampleText.split(",");

        // 1과 2로 잘 분리되는지 확인
        assertThat(splitedText).containsExactly("1", "2");

        // 1만을 포함하는 배열이 반환되는지 학인
        assertThat(splitedText).contains("1");
    }

    /**
     * 요구사항 2
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    @DisplayName("요구사항2")
    void stringTestNo2(){
        String sampleText = "(1,2)";
        int indexOfOpen = sampleText.indexOf("(") + 1;
        int indexOfClose = sampleText.lastIndexOf(")");
        String substringedText = sampleText.substring(indexOfOpen, indexOfClose);

        // "1,2"가 반환되는지 확인
        assertThat(substringedText).isEqualTo("1,2");
    }

    /**
     * 요구사항 3
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("요구사항3 : charAt() 메소드 사용 시 StringIndexOutOfBoundsException이 발생하는 것을 확인")
    void stringTestNo3(){
        String sampleText = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    sampleText.charAt(10);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
