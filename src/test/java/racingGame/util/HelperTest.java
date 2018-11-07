package racingGame.util;

import org.junit.Before;
import org.junit.Test;
import racingGame.model.RacingCarVO;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HelperTest {
    List<RacingCarVO> snapshots;

    @Before
    public void setUp() {
        snapshots = new ArrayList<>();
        snapshots.add(new RacingCarVO("test1", 1));
        snapshots.add(new RacingCarVO("test2", 2));
        snapshots.add(new RacingCarVO("test3", 4));
    }

    @Test
    public void 최대값 () {
        assertThat(Helper.getHighestPosition(snapshots)).isEqualTo(4);
    }
}