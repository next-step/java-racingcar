package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnerTest {
    private Winner winner;

    @BeforeEach
    public void setUp() {
        List<CarRace> carRaceGroup = new ArrayList<>();
        carRaceGroup.add(new CarRace(new CarName("BMW"), new CarPosition(0)));
        carRaceGroup.add(new CarRace(new CarName("KIA"), new CarPosition(1)));
        carRaceGroup.add(new CarRace(new CarName("HONDA"), new CarPosition(2)));

        winner = new Winner(new CarRaceGroup(carRaceGroup));
    }

    @Test
    @DisplayName("가장 높은 위치값 확인")
    public void checkPositionMax() {
        assertThat(winner.positionMax()).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자 이름 확인")
    public void checkWinnerNames() {
        assertThat(winner.findWinner()).isEqualTo("HONDA");
    }
}
