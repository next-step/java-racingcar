package stringtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현")
    @Test
    void test1() throws Exception {
        String str = "1,2";
        String[] split = str.split(",");
        assertThat(split).contains("1", "2");
    }

    @DisplayName(" 1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    @Test
    void test2() throws Exception {
        String str = "1";
        String[] split = str.split(",");
        assertThat(split).containsOnly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    @Test
    void test3() throws Exception {
        String str = "(1,2)";
        String substring = str.substring(1, str.length() - 1);

        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("abc 중 a를 가져올 수 있다.")
    @Test
    void test4() throws Exception {
        String str = "abc";

        char target = str.charAt(0);
        String result = String.valueOf(target);

        assertThat(result).isEqualTo("a");
    }

    @DisplayName("abc 중 b를 가져올 수 있다.")
    @Test
    void test5() throws Exception {
        String str = "abc";

        char target = str.charAt(1);
        String result = String.valueOf(target);

        assertThat(result).isEqualTo("b");
    }

    @DisplayName("abc 중 c를 가져올 수 있다.")
    @Test
    void test6() throws Exception {
        String str = "abc";

        char target = str.charAt(2);
        String result = String.valueOf(target);

        assertThat(result).isEqualTo("c");
    }

    @DisplayName("문자를 가져올 때 위치 값을 벗어나면 예외가 발생한다.")
    @Test
    void test7() throws Exception {
      String str = "abc";

      assertThatThrownBy(() -> str.charAt(str.length()))
          .isInstanceOf(StringIndexOutOfBoundsException.class)
          .hasMessageMatching("String index out of range: \\d+");
    }


}
