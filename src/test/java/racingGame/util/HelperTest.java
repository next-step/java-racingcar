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
        snapshots.add(new RacingCarVO("test4", 4));
    }

    @Test
    public void 최대값() {
        assertThat(Helper.getHighestPosition(snapshots)).isEqualTo(4);
    }

    @Test
    public void 자동차_이름_목록_추출() {
        List<String> carNames = Helper.extractCarNames(snapshots);

        assertThat(carNames.get(0)).isEqualTo("test1");
        assertThat(carNames.get(1)).isEqualTo("test2");
        assertThat(carNames.get(2)).isEqualTo("test3");
        assertThat(carNames.get(3)).isEqualTo("test4");
    }

    @Test
    public void 자동차_위치_목록_추출() {
        List<Integer> carPositions = Helper.extractCarPositions(snapshots);

        assertThat(carPositions.get(0)).isEqualTo(1);
        assertThat(carPositions.get(1)).isEqualTo(2);
        assertThat(carPositions.get(2)).isEqualTo(4);
        assertThat(carPositions.get(3)).isEqualTo(4);
    }

    @Test
    public void 특정_위치를_가지는_자동차_목록_추출() {
        List<RacingCarVO> filteredSnapshots = Helper.filterRacingCar(snapshots, 2);

        assertThat(filteredSnapshots.size()).isEqualTo(1);
        assertThat(filteredSnapshots.get(0).getName()).isEqualTo("test2");
        assertThat(filteredSnapshots.get(0).getPosition()).isEqualTo(2);
    }

    @Test
    public void 우승한_자동차_목록_추출() {
        int highestPosition = Helper.getHighestPosition(snapshots);
        List<RacingCarVO> championSnapshots = Helper.filterRacingCar(snapshots, highestPosition);

        assertThat(highestPosition).isEqualTo(4);
        assertThat(championSnapshots.size()).isEqualTo(2);
        assertThat(championSnapshots.get(0).getName()).isEqualTo("test3");
        assertThat(championSnapshots.get(0).getPosition()).isEqualTo(highestPosition);
        assertThat(championSnapshots.get(1).getName()).isEqualTo("test4");
        assertThat(championSnapshots.get(1).getPosition()).isEqualTo(highestPosition);
    }
}