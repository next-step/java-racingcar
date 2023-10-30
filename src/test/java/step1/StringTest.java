package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName(", 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 테스트")
    void splitWithComma() {
        // given
        String testValue = "1,2";
        // when
        String[] result = testValue.split(",");
        // then
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 , 로 split 했을때 1만 포함하는 배열이 반환하는지 확인하는 테스트")
    void splitWithNotExist() {
        // given
        String testValue = "1";
        // when
        String[] result = testValue.split(",");
        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
        assertThat(result).hasSize(1);
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 substring 메소드를 활용해 괄호를 제거하는 테스트")
    void substring() {
        // given
        String leftBracket = "(";
        String rightBracket = ")";
        String testValue = "(1,2)";
        // when
        String result = testValue.substring(testValue.indexOf(leftBracket)+1, testValue.lastIndexOf(rightBracket));
        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("적절한 범위의 index를 이용하여 charAt 메서드를 사용하면 해당 index 의 글자를 찾을 수 있다.")
    void charAt() {
        // given
        String testValue = "abc";
        int[] indexes = new int[]{0, 1, 2};
        char[] searchValue = new char[]{'a', 'b', 'c'};
        char[] targetArray = new char[3];
        // when
        for (int index : indexes) {
            char target = testValue.charAt(index);
            targetArray[index] = target;
        }
        // then
        assertThat(targetArray).isEqualTo(searchValue);
    }

    @Test
    @DisplayName("index 범위에 벗어나는 값을 charAt 메서드에 사용한다면 IndexOutOfBoundsException 이 발생합니다.")
    void IndexOutOfBoundsException() {
        // given
        String testValue = "abc";
        int[] indexes = new int[]{-1, 4};
        // when // then
        assertThatThrownBy(() -> testValue.charAt(indexes[0]))
                .isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> testValue.charAt(indexes[1]))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
