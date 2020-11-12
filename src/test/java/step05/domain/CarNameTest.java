package step05.domain;

import exception.EmptyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarNameTest {

    @DisplayName("이름이 비었는지 검사")
    @ParameterizedTest
    @NullAndEmptySource
    public void test_isBlank (String blackName) {
        assertThatExceptionOfType(EmptyException.class)
                .isThrownBy(() -> CarName.of(blackName));
    }

    /*
        - 이름 검사 아래 2가지
    - 메서드
        - 이름이 비었는지 검사 private void isBlank
        - 이름이 5자 이하인지 검사 private void isInBoundLength
        - 이름 객체 반환 public CarName getName
     */
}
