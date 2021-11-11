package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Cars;
import racing.service.ConvertInput;
import racing.service.ConvertOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {

    @Test
    @DisplayName("이름이 잘 들어가는지 테스트")
    void carNameTest() {
        String name = "a,b,c,d,e";
        ConvertInput convertInput = new ConvertInput();
        List<String> nameList = convertInput.convertInput(name);
        Cars cars = new Cars(nameList);
        for (int i =0;i<5;i++) {
            assertEquals(cars.getCarList().get(i).getName(),nameList.get(i));
        }
    }

    @Test
    @DisplayName("ConvertOutputView 가 잘 적용되는지 테스트")
    void convertOutputViewTest() {
        List<String> expectedList = new ArrayList<String>(Arrays.asList("-", "-", "-"));
        String[] nameArray = {"1", "2", "3"};
        List<String> nameList = Arrays.asList(nameArray);
        Cars cars = new Cars(nameList);
        for (int i = 0; i < 3; i++) {
            assertEquals(ConvertOutputView.convertOutputView(cars.getCarList().get(i).getPosition()), expectedList.get(i));
        }
    }

    @Test
    @DisplayName("초기 car의 position이 0으로 들어가는지 테스트")
    void initialCarListTest() {
        List<String> expectedList = new ArrayList<String>(Arrays.asList("-", "-", "-"));
        String[] nameArray = {"1", "2", "3"};
        List<String> nameList = Arrays.asList(nameArray);
        Cars cars = new Cars(nameList);
        for (int i = 0; i < 3; i++) {
            assertEquals(ConvertOutputView.convertOutputView(cars.getCarList().get(i).getPosition()), expectedList.get(i));
        }
    }

    @Test
    @DisplayName("RandomMoveStrategy 테스트")
    void carListTest() {
        List<String> expectedList = new ArrayList<String>(Arrays.asList("---", "-", "--"));
        String[] nameArray = {"1", "2", "3"};
        List<String> nameList = Arrays.asList(nameArray);
        Cars cars = new Cars(nameList);
        cars.getCarList().get(1).movable(()->false);
        cars.getCarList().get(0).movable(()->true);
        cars.getCarList().get(0).movable(()->true);
        cars.getCarList().get(2).movable(()->true);
        for (int i = 0; i < 3; i++) {
            assertEquals(ConvertOutputView.convertOutputView(cars.getCarList().get(i).getPosition()), expectedList.get(i));
        }
    }

}
