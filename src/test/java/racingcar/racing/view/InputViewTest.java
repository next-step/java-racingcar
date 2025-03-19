package racingcar.racing.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class InputViewTest {
    @DisplayName("input 테스트, 유효하지 않은 문자열은 정상 범위 숫자가 나올 때까지 next")
    @Test
    public void validInput() {
        System.setIn(new ByteArrayInputStream("abcdsa,a,c,d,d\na,b,c,d,e\na\n-5\n3\n".getBytes()));

        Assertions.assertThat(InputView.getStringListInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", ","))
                .containsExactly("a","b","c","d","e");
        Assertions.assertThat(InputView.getPositiveNumberInput("시도할 회수는 몇 회 인가요?")).isEqualTo(3);

        System.setIn(System.in);
    }
}