package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    // 요구사항 1
    @Test
    void split() {
        String inputTest;
        String[] result;

        inputTest = "1,2";
        result = inputTest.split(",");
        assertThat(result).containsExactly("1", "2");

        inputTest = "1";
        result = inputTest.split(",");
        assertThat(result).contains("1");
    }

    // 요구사항 2
    @Test
    void substring() {
        String inputTest = "(1,2)";
        String result = inputTest.substring(1, 4);
        assertThat(result).contains("1,2");
    }

    // 요구사항 3
    @Test
    @DisplayName("StringIndexOutOfBoundsException 테스트")
    void charAt() {
        String inputTest = "abc";
        assertThatThrownBy(() -> {
            /*
                질문1
                이 안의 코드는 무조건 예외처리되나요?
                inputTest.charAt(1);
                위 처럼 정상 코드를 넣어도 에러로 처리되는데 정상적인건지 이해가 되지않아 질문드립니다.
                무조건 예외처리라면 코드 실행중에 문제가있을때 예외가 아닌 일부로 예외를 낸 코드를 테스트 하는것으로 이해됩니다.
                답변 주시면 감사하겠습니다 :)
            */
            inputTest.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index:2, Size: 2");
    }
}
