package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetClassStudy {


    @Nested
    @DisplayName("[요구사항1] 정수로 구성된 Set Collection")
    class Describe_SetCollectionFirst {

        @Nested
        @DisplayName("이 주어진다면 ")
        class Context_with_Given {

            private final static int SHOULD_RETURN_SIZE = 5;
            private final Set<Integer> GIVEN_COLLECTION = Set.of(1, 2, 3, 4, 5);

            @Test
            @DisplayName("Set Collection의 크기를 반환한다")
            void returnCollectionSize() {

                assertThat(GIVEN_COLLECTION.size()).isEqualTo(SHOULD_RETURN_SIZE);
            }
        }
    }


    @Nested
    @DisplayName("[요구사항2] 정수로 구성된 Set Collection")
    class Describe_SetCollectionSecond {


        @Nested
        @DisplayName("이 주어진다면 ")
        class Context_with_Given {

            private final Set<Integer> GIVEN_COLLECTION = Set.of(1, 2, 3, 4, 5);

            @ParameterizedTest(name = "[{index}] 번째 요소:{arguments}")
            @ValueSource(ints = {1, 2, 3, 4, 5})
            @DisplayName("콜렉션 요소들의 값들을 확인한다")
            void returnValidateValues(int number) {

                assertThat(GIVEN_COLLECTION).contains(number);
            }
        }
    }


    @Nested
    @DisplayName("[요구사항2] 문자열로 구성된 Set Collection")
    class Describe_SetStringCollection {


        @Nested
        @DisplayName("이 주어진다면 ")
        class Context_with_Given {

            private final Set<Integer> GIVEN_COLLECTION = Set.of(1, 2, 3, 6, 7);

            @ParameterizedTest(name = "[{index}] 번째 요소:{arguments}")
            @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
            @DisplayName("콜렉션 요소들의 값들을 확인한다")
            void returnValidateValues(int number, boolean expected) {

                assertThat(GIVEN_COLLECTION.contains(number)).isEqualTo(expected);
            }
        }
    }

}
