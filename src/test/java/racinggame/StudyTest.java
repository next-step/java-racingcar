package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StudyTest {
    @DisplayName("변경 불가능한 리스트로 반환")
    @Test
    void toUnmodifiableListTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> multiplyNumber = numbers.stream().map(num -> num * 2).collect(Collectors.toUnmodifiableList());

        assertThatThrownBy(
                () -> multiplyNumber.add(5))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
