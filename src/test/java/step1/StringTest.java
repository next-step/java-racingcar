package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("String 클래스 학습 테스트")
class StringTest {

    @DisplayName("요구사항1 - split 테스트")
    @ParameterizedTest
    @CsvSource(value = {"'1,2':1,2", "'1':1"}, delimiter = ':')
    void splitTest(String value, @ConvertWith(CSVtoArray.class) String... expected) {
        String[] split = value.split(",");
        assertThat(split).containsExactly(expected);
    }

    @DisplayName("요구사항2 - substring 테스트")
    @Test
    void substringTest() {
        String substring = "(1,2)".substring(1, "(1,2)".length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("요구사항3 - charAt 테스트")
    @Test
    void chatAtTest() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @DisplayName("요구사항3 - chatAt 오류 확인 테스트")
    @Test
    void chatAtExceptionTest() {
        assertThatThrownBy(() -> "abc".charAt("abc".length())).isInstanceOf(StringIndexOutOfBoundsException.class)
                                                              .hasMessageContaining("String index out of range");
    }

    public static class CSVtoArray extends SimpleArgumentConverter {
      @Override
      protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        return ((String) source).split("\\s*,\\s*");
      }
    }
}
