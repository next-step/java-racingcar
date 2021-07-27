package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @DisplayName("이름이 1글자~5글자 사이일 경우 객체생성")
    @ParameterizedTest
    @ValueSource(strings = {"바나나", "파인애플", "감", "천도복숭아"})
    void testCreateName(String input) {
        assertThat(new Name(input)).isInstanceOf(Name.class);
    }

    @DisplayName("이름이 null일 경우 IllegalArgumentException throw")
    @Test
    void testInputNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name(null);
        }).withMessageMatching("자동차의 이름을 입력해주세요.");
    }

    @DisplayName("이름이 비었을 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"  ", ""})
    void testInputEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name(input);
        }).withMessageMatching("자동차의 이름을 입력해주세요.");
    }

    @DisplayName("이름이 1글자~5글자 사이가 아닐 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"레인보우샤베트", "엄마는외계인", "쿠키앤크림치즈"})
    void testInputLongName(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name(input);
        }).withMessageMatching("자동차의 이름은 1~5글자 사이로 입력해야 합니다.");
    }
    
    @DisplayName("입력한 이름을 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"원숭이", "코끼리", "푸마", "불독"})
    void testGetName(String input) {
        assertThat(new Name(input).getName()).isEqualTo(input.trim());
    }

}