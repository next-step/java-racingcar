package study;

import org.assertj.core.internal.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SetTest {

    Set<Integer> numberSet = new HashSet<>();

    @BeforeEach
    void setUp() {
        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);
        numberSet.add(3);
    }

    @Test
    @DisplayName("check not in duplicated number")
    void sizeTest() {
        assertThat(numberSet).hasSize(3);
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void containTest(int number, boolean expected) {
        assertThat(numberSet.contains(number)).isEqualTo(expected);
    }

}
