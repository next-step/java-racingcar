package racing.model.mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/** nextInt()를 10번 돌리면 1: 3번, 7: 7번 나오는 Mock Random 생성기 */
public class MockRandom extends Random {

    private static final List<Integer> sequences = Collections.unmodifiableList(
            Arrays.asList(1, 1, 1, 7, 7, 7, 7, 7, 7, 7));

    private int nowIndex = 0;

    @Override
    public int nextInt(int bound) {
        nowIndex = (nowIndex + 1) % 10;
        return sequences.get(nowIndex);
    }
}
