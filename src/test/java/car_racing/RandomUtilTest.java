package car_racing;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {

    @Test
    void getRandomNumber() {
        // given
        int from = 0;
        int to = 5;

        Set<Integer> possibleSet = new HashSet<Integer>(){{
            add(0); add(1); add(2); add(3); add(4); add(5);
        }};

        Set<Integer> impossibleSet = new HashSet<Integer>(){{
            add(6); add(7); add(8); add(9); add(10); add(11);
        }};

        // when
        int result = RandomUtil.getRandomNumber(from, to);

        // then
        System.out.println("random number is: " + result);
        assertThat(result).isIn(possibleSet);
        assertThat(result).isNotIn(impossibleSet);
    }
}