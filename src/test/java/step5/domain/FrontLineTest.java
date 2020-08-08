package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.DefaultArgumentConverter;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step5.domain.FrontLine.validNames;

public class FrontLineTest {
    @DisplayName("선수 명 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"null", "  "})
    void validation_inputName_success(@ConvertWith(NullableConverter.class) String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> validNames(input));
    }
}

final class NullableConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if ("null".equals(source)) {
            return null;
        }
        return DefaultArgumentConverter.INSTANCE.convert(source, targetType);
    }
}