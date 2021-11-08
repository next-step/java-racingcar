package step3;

import org.junit.jupiter.api.Test;
import step3.model.CarList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CarListTest {
    @Test
    void carListTest() {
        ArrayList<String> expectedList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            expectedList.add("-");
        }
        ArrayList<String> carList = CarList.makeCarList(5);
        assertEquals(carList, expectedList);
        }
    }
