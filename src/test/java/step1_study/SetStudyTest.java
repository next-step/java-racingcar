package step1_study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

public class SetStudyTest {

    private Set numbers;
    @BeforeEach
    void setup(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void sizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void containsTest(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isContains(int number){
        assertThat( numbers.contains(number)).isTrue();
    }
}
