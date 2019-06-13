import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest {

    /*
    요구사항 : "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     */
    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    /*
    요구사항 : "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    /*
    요구사항 : "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    /*
    요구사항 : "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     */
    @Test
    void charAt1() {
        String str = "abc";

        char firstLetter = str.charAt(0);
        char secondLetter = str.charAt(1);
        char thirdLetter = str.charAt(2);

        assertThat(firstLetter).isEqualTo('a');
        assertThat(secondLetter).isEqualTo('b');
        assertThat(thirdLetter).isEqualTo('c');
    }

    /*
    요구사항 : String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
             StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     */
    @Test
    void charAt2() {
        String str = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                str.charAt(5);
            }).withMessage("String index out of range: 5");
    }
}
