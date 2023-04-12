package study.racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameValidatorTest {

  private static Stream<Arguments> provideArgumentsForValidatedCarNames() {
    return Stream.of(
            Arguments.of("oneny,twony,tobi", Arrays.asList("oneny", "twony", "tobi")),
            Arguments.of("pobi,crong,honux", Arrays.asList("pobi", "crong", "honux"))
    );
  }

  @ParameterizedTest(name = "carNames 5자 이하로 입력 시 List<String> 반환 테스트")
  @MethodSource("provideArgumentsForValidatedCarNames")
  public void validatedCarNames_5자_이하_이름_입력(String input, List<String> expected) {
    List<String> result = NameValidator.validatedCarNames(input);
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest(name = "carNames 빈 문자열 또는 null 값이 들어간 경우 IllegalArgumentException 발생 테스트")
  @NullAndEmptySource
  public void validatedCarNames_빈문자열_또는_Null(String input) {
    assertThatThrownBy(() -> NameValidator.validatedCarNames(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("등록할 레이싱카 이름들을 입력해주세요.");
  }

  @ParameterizedTest(name = "carName 빈 문자열이 들어간 경우 IllegalArgumentException 발생 테스트")
  @ValueSource(strings = {",oneny,twony", "oneny,,twony", ",,oneny"})
  public void validatedCarNames_carName_빈문자열(String input) {
    assertThatThrownBy(() -> NameValidator.validatedCarNames(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("레이싱카 이름을 입력하시지 않았습니다.");
  }

  @Test
  @DisplayName("carName 5자 이상 시 IllegalArgumentException 발생 테스트")
  public void validatedCarNames() {
    assertThatThrownBy(() -> NameValidator.validatedCarNames("threeny,fourny"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("5자 초과된 이름이 입력되었습니다. 입력된 이름: threeny");
  }
}
