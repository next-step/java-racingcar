package study;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import com.racing.game.entity.Car;
import com.racing.game.entity.CarRace;
import com.racing.game.RaceStorage;
import com.racing.game.entity.RaceEntry;
import com.racing.game.utils.InputUtils;
import com.racing.game.viewmodel.InputViewModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RaceStorage raceStorage;

    @BeforeEach
    void setUp() {
        raceStorage = new RaceStorage();
    }

    @Test
    void carNames_split() {
        String dummy = "pobi,crong,honox";
        String[] expect = {"pobi", "crong", "honox"};
        assertLinesMatch(List.of(InputUtils.toSplitList(dummy)), List.of(expect));
    }

    @Test
    void carNames_toCarList() {
        String dummy = "pobi,crong,honox";
        String[] expect = {"pobi", "crong", "honox"};
        assertIterableEquals(InputUtils.toCarList(dummy),
                List.of(Car.from("pobi"), Car.from("crong"), Car.from("honox")));
    }

    @Test
    void carName_5글자초과예외() {
        String dummy = "nextStep";
        assertThatThrownBy(()->{
            Car.from(dummy);
        }).hasMessageContaining("자동차 이름은 5글자를 넘어서면 안됩니다.");
    }

    @Test
    void saveCar() {
        InputViewModel viewModel = new InputViewModel(raceStorage);

        viewModel.saveCar(RaceEntry.from(List.of(Car.from("pobi"))));

        assertIterableEquals(List.of(Car.from("pobi")), raceStorage.raceStatus(0).lineup());
    }

    @Test
    void carRace_resultSize_1by1() {
        raceStorage.saveNextRaceEntry(RaceEntry.from(new ArrayList<>(List.of(Car.from("pobi")))));
        raceStorage.saveLaps(1);

        CarRace race = new CarRace(raceStorage);
        race.race();

        assertThat(raceStorage.carCount()).isEqualTo(1);
        assertThat(raceStorage.totalLaps()).isEqualTo(1);
    }

    @Test
    void carRace_resultSize_3by5() {
        raceStorage.saveNextRaceEntry(
                RaceEntry.from(new ArrayList<>(List.of(Car.from("crong"), Car.from("honux"), Car.from("abc")))));
        raceStorage.saveLaps(5);

        CarRace race = new CarRace(raceStorage);
        race.race();

        assertThat(raceStorage.carCount()).isEqualTo(3);
        assertThat(raceStorage.totalLaps()).isEqualTo(5);
    }

    @Test
    void saveTryCount() {
        InputViewModel viewModel = new InputViewModel(raceStorage);
        viewModel.saveLaps(5);
        assertThat(raceStorage.totalLaps()).isEqualTo(5);
    }

    @Test
    void resultString() {
        raceStorage.saveNextRaceEntry(
                RaceEntry.from(new ArrayList<>(List.of(Car.from("crong"), Car.from("honux"), Car.from("abc")))));

        assertThat(raceStorage.lapToReport(0).toString()).hasToString("crong : \nhonux : \nabc : \n");
    }
}
