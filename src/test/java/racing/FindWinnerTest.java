package racing;

import org.junit.jupiter.api.Test;
import racing.model.Cars;
import racing.service.ConvertInput;
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
        ConvertInput convertInput = new ConvertInput();
        Cars cars = new Cars(convertInput.convertInput(nameString));
        cars.getCarList().get(0).movable(() -> true);
        cars.getCarList().get(0).movable(() -> true);
        cars.getCarList().get(0).movable(() -> true);
        cars.getCarList().get(1).movable(() -> true);
        cars.getCarList().get(1).movable(() -> true);
        cars.getCarList().get(1).movable(() -> true);
        assertEquals(FindWinner.findWinner(cars).stream().map(i->i.getName()).collect(Collectors.toList()),expectedList);
    }
}