package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetClassStudy {


    @Nested
    @DisplayName("[요구사항1] Set Collection")
    class Describe_SetCollection {

        private final Set<Integer> GIVEN_COLLECTION = Set.of(1, 2, 3, 4, 5);

        @Nested
        @DisplayName("이 주어진다면 ")
        class Context_with_Given {

            private final static int SHOULD_RETURN_SIZE = 5;

            @Test
            @DisplayName("Set Collection의 크기를 반환한다")
            void returnCollectionSize() {

                assertThat(GIVEN_COLLECTION.size()).isEqualTo(SHOULD_RETURN_SIZE);
            }
        }
    }


}
