package study1.winner.code.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class NameTest {

  @ParameterizedTest
  @CsvSource(value = {" pobi:pobi", "tim :tim"}, delimiter = ':')
  @DisplayName("참가자의 이름에 공백이 있는 값과 없는 값의 결과값이 같은지 테스트")
  public void autoTrim(String notTrim, String trim) {
    Name nameOfNotTrim = new Name(notTrim);
    Name nameOfTrim = new Name(trim);

    assertThat(nameOfNotTrim.name()).isEqualTo(nameOfTrim.name());
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("참가자 String 값이 null or 공백인 경우 에러를 리턴하는지 테스트")
  public void isEmpty(String name) {
    assertThatThrownBy(() -> {
      new Name(name);
    }).isInstanceOf(IllegalArgumentException.class);
  }
  
}
