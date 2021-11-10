package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Car;
import step3.model.CarList;
import step3.service.ConvertOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarListTest {
    @Test
    @DisplayName("ConvertOutputView 가 잘 적용되는지 테스트")
    void convertOutputViewTest() {
        List<String> expectedList = new ArrayList<String>(Arrays.asList("-", "-", "-"));
        CarList carList = new CarList(3);
        for (int i = 0; i < 3; i++) {
            assertEquals(ConvertOutputView.convertOutputView(carList.getCarList().get(i).getPosition()), expectedList.get(i));
        }
    }

    @Test
    @DisplayName("초기에 countOfCar을 입력받아 만들어지는 carList 의 여러 car의 position이 0으로 들어가는지 test")
    void initialCarListTest() {
        List<String> expectedList = new ArrayList<String>(Arrays.asList("-", "-", "-"));
        CarList carList = new CarList(3);
        for (int i = 0; i < 3; i++) {
            assertEquals(ConvertOutputView.convertOutputView(carList.getCarList().get(i).getPosition()), expectedList.get(i));
        }
    }

    @Test
    @DisplayName("carList RandomMoveStrategy test")
    void carListTest() {
        List<String> expectedList = new ArrayList<String>(Arrays.asList("---", "-", "--"));

        CarList carList = new CarList(3);
        carList.getCarList().get(1).movable(()->false);
        carList.getCarList().get(0).movable(()->true);
        carList.getCarList().get(0).movable(()->true);
        carList.getCarList().get(2).movable(()->true);
        for (int i = 0; i < 3; i++) {
            assertEquals(ConvertOutputView.convertOutputView(carList.getCarList().get(i).getPosition()), expectedList.get(i));
        }
    }
}
