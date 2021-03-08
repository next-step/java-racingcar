import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set Collection size Test")
    @Test
    public void setSizeTest() {
        //given preconditions

        //when
        int size = numbers.size();

        //then149717
        assertThat(size).isEqualTo(3);

    }


    @DisplayName("Set Collection contain Test")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void setCollectionContains(int i) {
        //given preconditions

        //when
        boolean isContain = numbers.contains(i);

        //then
        assertTrue(isContain);
    }

    @DisplayName("Set Collection Contain With Expected Return")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void setCollectionContainsWithExpectedReturn(int i, boolean expected) {
        //given preconditions

        //when
        boolean isContain = numbers.contains(i);

        //then
        assertEquals(expected, isContain);
    }
}

