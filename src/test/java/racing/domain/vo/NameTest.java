package racing.domain.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("이름값 유효성 체크 테스트")
    void validateNameNotBlankTest(){
        Assertions.assertThatThrownBy(() -> {
                    Name name = new Name("");
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어있거나 없으면 안됩니다.");
    }

}
