package step3;

import org.junit.jupiter.api.Test;
import step3.model.CarList;
import step3.service.MoveOrStop;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MoveOrStopTest {

    @Test
    void moveOrStopTest() {
        ArrayList<Integer> randomList = new ArrayList<>();
        randomList.add(1);
        randomList.add(9);
        randomList.add(5);
        Integer countOfCar = 3;
        ArrayList<String> carList = CarList.makeCarList(countOfCar);
        MoveOrStop moveOrStop = new MoveOrStop();
        ArrayList<String> movedCarList = moveOrStop.moveOrStop(carList, randomList);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("-");
        expectedList.add("--");
        expectedList.add("--");
        assertEquals(movedCarList, expectedList);
    }

}
