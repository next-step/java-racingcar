package study;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import com.racing.game.CarRace;
import com.racing.game.dto.RaceEntry;
import com.racing.game.dto.RaceResult;
import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.viewmodel.ResultViewModel;
import com.racing.game.vo.CarCount;
import com.racing.game.vo.TryCount;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    void carRace_resultSize() {
        assertThat(CarRace.race(RaceEntry.of(1, 1)).toResultForm().get(0)).hasSize(1);
        assertThat(CarRace.race(RaceEntry.of(1, 1)).toResultForm()).hasSize(1);
        assertThat(CarRace.race(RaceEntry.of(3, 5)).toResultForm().get(0)).hasSize(3);
        assertThat(CarRace.race(RaceEntry.of(3, 5)).toResultForm()).hasSize(5);
    }

    @Test
    void saveCarCount() {
        InputViewModel viewModel = new InputViewModel();
        viewModel.saveCarCount(CarCount.of(5));
        assertThat(viewModel.carCount().value()).isEqualTo(5);
    }

    @Test
    void saveTryCount() {
        InputViewModel viewModel = new InputViewModel();
        viewModel.saveTryCount(TryCount.of(5));
        assertThat(viewModel.tryCount().value()).isEqualTo(5);
    }

    @Test
    void saveRaceResult() {
        ResultViewModel viewModel = new ResultViewModel();
        RaceResult expected = RaceResult.of(new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 1, 0}, {1, 1, 1}});
        viewModel.saveRaceResult(RaceResult.of(new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 1, 0}, {1, 1, 1}}));
        assertIterableEquals(viewModel.raceResult().toResultForm(),expected.toResultForm());
    }

    @Test
    void toResultForm() {
        int[][] data = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}, {1, 1, 0}};
        assertThat(RaceResult.of(data).toResultForm())
                .containsExactly(Arrays.asList(1, 0, 1), Arrays.asList(1, 1, 1), Arrays.asList(2, 1, 2),
                        Arrays.asList(3, 2, 2));
    }
}
