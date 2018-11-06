package racingGame.util;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HelperTest {
    List<Integer> values;

    @Before
    public void setUp() {
        values = new ArrayList<>();
    }

    @Test
    public void 최대값 () {
        values.add(1);
        values.add(2);
        values.add(4);

        assertThat(Helper.getHighstValue(values)).isEqualTo(4);
    }
}