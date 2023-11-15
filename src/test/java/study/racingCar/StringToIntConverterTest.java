package study.racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.StringAddCalculator;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringToIntConverterTest {

    private StringToIntConverter converter;

    @BeforeEach
    void 생성(){
        this.converter = new StringToIntConverter();
    }

    @Test
    void 컨버터() {
        assertThat(converter.StringToIntConverter("2")).isEqualTo(2);
    }

    @Test
    void 오류테스트() {
        assertThatThrownBy(() -> converter.StringToIntConverter("a"))
                .isInstanceOf(NumberFormatException.class);
    }
}