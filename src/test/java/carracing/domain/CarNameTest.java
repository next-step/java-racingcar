package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("자동차 이름을 위한 테스트")
class CarNameTest {
    private static final String TEST_NAME_LETTER = "T";
    private static final int INVALID_MAX_BOUND_NAME_SIZE = CarName.MAX_NAME_SIZE + 1;
    private static final int INVALID_MIN_BOUND_NAME_SIZE = CarName.MIN_NAME_SIZE - 1;

    private static List<String> provideValidNames() {
        return provideNames(CarName.MIN_NAME_SIZE, CarName.MAX_NAME_SIZE);
    }

    private static List<String> provideInvalidNames() {
        return Arrays.asList(provideName(INVALID_MIN_BOUND_NAME_SIZE), provideName(INVALID_MAX_BOUND_NAME_SIZE));
    }

    private static List<String> provideNames(int startSize, int endSize) {
        List<String> names = new ArrayList<>();
        for (int i = startSize; i <= endSize; i++) {
            names.add(provideName(i));
        }
        return names;
    }

    private static String provideName(int neededSize) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < neededSize; i++) {
            name.append(TEST_NAME_LETTER);
        }
        return name.toString();
    }

    @DisplayName("유효한 자동차 이름 정보가 생성되는지 확인")
    @ParameterizedTest
    @MethodSource("provideValidNames")
    void createValidNameTest(String expected) {
        // when
        CarName carName = new CarName(expected);
        // then
        assertAll(
                () -> assertThat(carName).isNotNull(),
                () -> assertThat(carName.getName()).isEqualTo(expected)
        );
    }

    @DisplayName("유효하지 않은 자동차 이름 정보가 예외를 발생하는지 확인")
    @ParameterizedTest
    @MethodSource("provideInvalidNames")
    void checkExceptionWithInvalidNameTest(String invalidName) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CarName(invalidName)
        );
    }
}
