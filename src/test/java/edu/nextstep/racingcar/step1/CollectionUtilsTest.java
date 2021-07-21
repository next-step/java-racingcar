package edu.nextstep.racingcar.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection에 대한 학습 테스트")
class CollectionUtilsTest {

    private CollectionUtils collectionUtils = null;

    @BeforeEach
    void setUp() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        collectionUtils = new CollectionUtils(numbers);
    }

    @DisplayName("요구사항 1")
    @Test
    void size_req_01() {
        assertThat(collectionUtils.getSize()).isEqualTo(3);
    }

    @DisplayName("요구사항 2-1")
    @Test
    void contains_req_01() {
        assertThat(collectionUtils.getNumbers().contains(1)).isTrue();
        assertThat(collectionUtils.getNumbers().contains(2)).isTrue();
        assertThat(collectionUtils.getNumbers().contains(3)).isTrue();
    }

    @ParameterizedTest(name = "요구사항 2-2, Parameter = {0}")
    @ValueSource(ints = {1, 2, 3})
    void contains_req_02(int param) {
        assertThat(collectionUtils.getNumbers().contains(param)).isTrue();
    }

    @ParameterizedTest(name = "요구사항 3, Parameter = {0}, {1}")
    @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
    void contains_req_03(String input, boolean expected) {
        StringUtils stringUtils = new StringUtils(input);

        for (String value : stringUtils.splitByComma()) {
            assertThat(collectionUtils.getNumbers().contains(Integer.valueOf(value))).isEqualTo(expected);
        }
    }
}