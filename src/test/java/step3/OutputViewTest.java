package step3;

import org.junit.jupiter.api.Test;
import step3.model.CarList;
import step3.view.Output;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OutputViewTest {

    @Test
    void convertOutputView() {
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("-");
        expectedList.add("--");
        expectedList.add("--");
        Output output = new Output();
        CarList carList = new CarList(3);
        carList.getCarList().get(1).movable(()->true);
        carList.getCarList().get(2).movable(() -> true);

        for (int i = 0; i < 3; i++) {
            assertEquals(output.convertOutputView(carList.getCarList().get(i).getPosition()), expectedList.get(i));
        }
    }
}
