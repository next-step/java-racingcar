package study;


import static org.assertj.core.api.Assertions.assertThat;

import com.racing.game.CarRace;
import com.racing.game.dto.RaceEntry;
import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.vo.CarCount;
import com.racing.game.vo.TryCount;
import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    void carRace() {
        assertThat(CarRace.race(RaceEntry.of(1, 1))).hasDimensions(1, 1);
        assertThat(CarRace.race(RaceEntry.of(5, 5))).hasDimensions(5, 5);
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
}
