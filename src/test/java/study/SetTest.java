package study;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author : dokim
 * @version :
 * @see <pre>
 * == Modification Information ==<br/>
 *
 *         Date        :       User          :     Description      <br/>
 * ---------------------------------------------------------------  <br/>
 *       2019-10-24      :       dokim        :                       <br/>
 *
 * </pre>
 * @since : 2019-10-24
 **/
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    void size() {
        //assertThat(numbers);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void contains(int no) {
        //assertThat(numbers.contains(no)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "4:false"}, delimiter = ':')
    void contains2(int no, boolean result) {
        assertThat(numbers.contains(no)).isEqualTo(result);
    }
}