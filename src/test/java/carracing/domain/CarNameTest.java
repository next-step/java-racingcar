package carracing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("자동차 이름을 위한 테스트")
class CarNameTest {

    private static final int MIN_NAME_SIZE = CarName.MIN_NAME_SIZE;
    private static final int MAX_NAME_SIZE = CarName.MAX_NAME_SIZE;
    private static final String TEST_NAME_LETTER = "T";
    private static final int INVALID_MAX_BOUND_NAME_SIZE = MAX_NAME_SIZE + 1;
    private static final int INVALID_MIN_BOUND_NAME_SIZE = MIN_NAME_SIZE - 1;

    @DisplayName("유효한 자동차 이름 정보가 생성되는지 확인")
    @ParameterizedTest
    @MethodSource("provideValidNames")
    void createValidNameTest(String expected) {
        // When
        CarName carName = new CarName(expected);

        // Then
        assertThat(carName.getName()).isEqualTo(expected);
    }

    @DisplayName("유효하지 않은 자동차 이름 정보가 예외를 발생하는지 확인")
    @ParameterizedTest
    @MethodSource("provideInvalidNames")
    void checkExceptionWithInvalidNameTest(String invalidName) {
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CarName(invalidName)
        );
    }

    private static List<String> provideValidNames() {
        return provideNames(MIN_NAME_SIZE, MAX_NAME_SIZE);
    }

    private static Stream<Object> provideInvalidNames() {
        return Stream.of(
                null,
                provideName(INVALID_MIN_BOUND_NAME_SIZE),
                provideName(INVALID_MAX_BOUND_NAME_SIZE)
        );
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
}
