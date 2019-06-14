package calculator.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

class CollectionUtilsTest {
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Test
    void List를_Stack으로_변환_테스트() {
        Stack<Integer> stack = CollectionUtils.convertListToStack(list);

        assertThat(stack).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void 기존List의_역순인_새로운_리스트_생성_테스트() {
        List<Integer> reversedList = CollectionUtils.reverse(list);

        assertThat(reversedList).containsExactly(5, 4, 3, 2, 1);
    }
}