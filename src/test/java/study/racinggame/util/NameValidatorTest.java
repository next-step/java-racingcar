package study.racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameValidatorTest {

  @ParameterizedTest(name = "carNames 5자 이하로 입력 시 List<String> 반환 테스트")
  @ValueSource(strings = {"oneny", "twony", "tobi"})
  public void validatedCarNames_5자_이하_이름_입력(String input) {
    String result = NameValidator.validatedCarName(input);
    assertThat(result).isEqualTo(input);
  }

  @ParameterizedTest(name = "carName 빈 문자열이나 null이 들어간 경우 IllegalArgumentException 발생 테스트")
  @NullAndEmptySource
  public void validatedCarNames_carName_빈문자열(String input) {
    assertThatThrownBy(() -> NameValidator.validatedCarName(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("레이싱카 이름을 입력하시지 않았습니다.");
  }

  @Test
  @DisplayName("carName 5자 이상 시 IllegalArgumentException 발생 테스트")
  public void validatedCarNames() {
    assertThatThrownBy(() -> NameValidator.validatedCarName("threeny"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("5자 초과된 이름이 입력되었습니다. 입력된 이름: threeny");
  }
}
