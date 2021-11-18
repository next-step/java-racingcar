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

}
