package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.utils.StringUtils;
import step4.utils.ValidationUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @DisplayName("자동차 이름 유효성 테스트")
    @Test
    public void valid_name() {
        assertThat(ValidationUtils.validationName("pobi")).isTrue();
    }

    @DisplayName("자동차 이름 유효성 테스트2")
    @Test
    public void invalid_name() {
        assertThat(ValidationUtils.validationName("kkkkkk")).isFalse();
        assertThat(ValidationUtils.validationName(" ")).isFalse();
        assertThat(ValidationUtils.validationName("")).isFalse();
        assertThat(ValidationUtils.validationName(null)).isFalse();
    }

    @DisplayName("'-'로 표현")
    @Test
    public void repeat() {
        String reuslt = StringUtils.repeat("-", 5);
        assertThat("-----");
    }
}
