package racing;

import org.junit.jupiter.api.Test;
import racing.model.Cars;
import racing.service.InputBuilder;
import racing.service.FindWinner;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindWinnerTest {

    @Test
    void FindWinnerTest() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("mj");
        expectedList.add("mj1");
        String nameString = "mj,mj1,mj2,mj3,mj4,mj5";
        Cars cars = new Cars(new InputBuilder(nameString).getNameList());
        cars.getCarList().get(0).movable(() -> true);
        cars.getCarList().get(0).movable(() -> true);
        cars.getCarList().get(0).movable(() -> true);
        cars.getCarList().get(1).movable(() -> true);
        cars.getCarList().get(1).movable(() -> true);
        cars.getCarList().get(1).movable(() -> true);
        assertEquals(FindWinner.findWinnerList(cars).stream().map(i->i.getName().getName()).collect(Collectors.toList()),expectedList);
    }
}