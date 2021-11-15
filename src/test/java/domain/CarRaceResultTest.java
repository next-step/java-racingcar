package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarRaceResultTest {
    private CarRaceResult carRaceResult;

    @BeforeEach
    public void setUp() {
        List<CarRace> carRaceGroup = new ArrayList<>();
        carRaceGroup.add(new CarRace(new CarName("BMW"), new CarPosition(0)));
        carRaceGroup.add(new CarRace(new CarName("KIA"), new CarPosition(1)));
        carRaceGroup.add(new CarRace(new CarName("HONDA"), new CarPosition(2)));

        carRaceResult = new CarRaceResult(new CarRaceGroup(carRaceGroup));
    }

    @Test
    @DisplayName("가장 높은 위치값 확인")
    public void checkPositionMax() {
        assertThat(carRaceResult.positionMax()).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자 이름 확인")
    public void checkWinnerNames() {
        assertThat(carRaceResult.winnerName()).isEqualTo("HONDA");
    }
}
