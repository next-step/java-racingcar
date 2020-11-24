package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberComparatorTest {

    @Test
    @DisplayName("랜덤값이 4 이상일 때만 True인가")
    public void numberComparate(){
        assertTrue(NumberComparator.isAndAboveValue(4));
        assertFalse(NumberComparator.isAndAboveValue(3));
    }
}
