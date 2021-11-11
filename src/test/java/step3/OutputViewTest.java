package step3;

import org.junit.jupiter.api.Test;
import racing.model.Cars;
import racing.service.ConvertOutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OutputViewTest {

    @Test
    void convertOutputView() {
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("-");
        expectedList.add("--");
        expectedList.add("--");
        String[] nameArray = {"1", "2", "3"};
        List<String> nameList = Arrays.asList(nameArray);
        Cars cars = new Cars(nameList);
        cars.getCarList().get(1).movable(()->true);
        cars.getCarList().get(2).movable(() -> true);

        for (int i = 0; i < 3; i++) {
            assertEquals(ConvertOutputView.convertOutputView(cars.getCarList().get(i).getPosition()), expectedList.get(i));
        }
    }
}
