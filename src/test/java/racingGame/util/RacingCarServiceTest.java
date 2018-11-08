package racingGame.util;

import org.junit.Before;
import org.junit.Test;
import racingGame.model.RacingCarDTO;
import racingGame.service.RacingCarService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingCarServiceTest {
    List<RacingCarDTO> snapshots;
    RacingCarService racingCarService;

    @Before
    public void setUp() {
        snapshots = new ArrayList<>();
        snapshots.add(new RacingCarDTO("test1", 1));
        snapshots.add(new RacingCarDTO("test2", 2));
        snapshots.add(new RacingCarDTO("test3", 4));
        snapshots.add(new RacingCarDTO("test4", 4));

        racingCarService = new RacingCarService(snapshots);
    }

    @Test
    public void 최대값() {
        assertThat(racingCarService.getHighestPosition()).isEqualTo(4);
    }

    @Test
    public void 자동차_위치_목록_추출() {
        List<Integer> carPositions = racingCarService.extractCarPositions();

        assertThat(carPositions.get(0)).isEqualTo(1);
        assertThat(carPositions.get(1)).isEqualTo(2);
        assertThat(carPositions.get(2)).isEqualTo(4);
        assertThat(carPositions.get(3)).isEqualTo(4);
    }

    @Test
    public void 특정_위치를_가지는_자동차_이름_추출() {
        List<String> carNames = racingCarService.extractCarNamesByPosition(2);

        assertThat(carNames.size()).isEqualTo(1);
        assertThat(carNames.get(0)).isEqualTo("test2");
    }

    @Test
    public void 우승한_자동차_이름_추출() {
        int highestPosition = racingCarService.getHighestPosition();
        List<String> championSnapshots = racingCarService.extractCarNamesByPosition(highestPosition);

        assertThat(highestPosition).isEqualTo(4);
        assertThat(championSnapshots.size()).isEqualTo(2);
        assertThat(championSnapshots.get(0)).isEqualTo("test3");
        assertThat(championSnapshots.get(1)).isEqualTo("test4");
    }
}