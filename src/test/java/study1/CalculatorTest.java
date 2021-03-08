package study1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import study1.calculator.CalculatorEnum;
import study1.calculator.CalculatorService;

public class CalculatorTest {
  @ParameterizedTest
  @ValueSource(strings = { "1 - -", "1 0 2" })
  @DisplayName("예외 테스트")
  void checkException(String str) {
    assertThatThrownBy(() -> {
      new CalculatorService(str).calculateAll(null);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = { "1 + 1:2", "3 - 1:2", "3 * 2:6", "4 / 2:2", "3 + 1 - 2 * 2 / 4:1" }, delimiter = ':')
  @DisplayName("정답 테스트")
  void checkAnswer(String str, int num) {
    int result = new CalculatorService(str).calculateAll(null);
    assertThat(result).isEqualTo(num);
  }
}
