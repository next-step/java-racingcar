package learningtest;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ListLearningTest {

    @DisplayName("List.of는 immutable list를 생성한다")
    @Test
    void immutable_list() {
        List<Long> createdByListOf = List.of(1L);

        Assertions.assertThatThrownBy(() -> {
            createdByListOf.add(2L);
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
