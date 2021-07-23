package study.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

  @ParameterizedTest
  @CsvSource(value = {"테스트카1,테스트카1", "테스트카2,테스트카2", "테스트카3,테스트카3"})
  void 이름생성후이름가져오기테스트(String input, String expected) {
    Name name = new Name(input);
    assertThat(name.getCarName()).isEqualTo(expected);
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  void 이름빈값확인테스트(String input) {
    assertThrows(IllegalArgumentException.class,
        ()->{
          new Name(input);
        });
  }

  @ParameterizedTest
  @ValueSource(strings = {"가나다라마바","하나둘셋넷다섯"})
  void 이름길이제한을넘으면에러발생확인테스트(String input) {
    assertThrows(IllegalArgumentException.class,
        ()->{
          new Name(input);
        });
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  @ValueSource(strings = {"가나다라마바","하나둘셋넷다섯"})
  void 벨리데이션종합테스트(String input) {
    assertThrows(IllegalArgumentException.class,
        ()->{
          new Name(input);
        });
  }
}