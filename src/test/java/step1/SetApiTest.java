package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetApiTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    @Test
    @DisplayName("Set Collection Size를 확인한다.")
    void 요구사항_1(){
        assertThat(numbers.size()).isEqualTo(3);
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인한다.")
    void 요구사항_2(int number){
        assertThat(numbers.contains(number)).isTrue();
    }
}
