package racing.domain.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("이름값 유효성 체크 테스트")
    void validateNameBlankThrowExceptionTest(){
        Assertions.assertThatThrownBy(() -> {
                    Name name = new Name("");
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어있거나 없으면 안됩니다.");
    }

    @Test
    @DisplayName("이름값 유효성 체크 테스트")
    void validateNameLengthLongerThanFiveThrowExceptionTest(){
        Assertions.assertThatThrownBy(() -> {
                    Name name = new Name("5글자넘는자동차");
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("이름값 추출 테스트")
    void getNameTest(){
        // Given
        final String expected = "LEE";
        // When
        Name name = new Name(expected);
        String actual = name.getName();
        // Then
        assertThat(actual).isEqualTo(expected);
    }

}
