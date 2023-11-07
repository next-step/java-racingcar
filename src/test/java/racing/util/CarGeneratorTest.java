package racing.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGeneratorTest {
    @Test
    @DisplayName("[CarGenerator.createMultipleCars] 3개 생성 요청 시 -> Car 객체가 딱 3개 담긴 리스트 반환")
    public void createMultipleCarsTest() {
        assertThat(CarGenerator.createMultipleDefaultCars(3))
                .hasSize(3);
    }

    @Test
    @DisplayName("[CarGenerator.createByMultiNameString] 이름 목록이 주어지면 -> 각 이름을 가진 자동차들 생성")
    public void createWithMultiNameString() {
        String multiNameString = "hello,world,my,name";

        List<Car> carList = CarGenerator.createByMultiNameString(multiNameString);

        List<String> nameList = new ArrayList<>();
        for (Car car : carList) {
            nameList.add(car.getName());
        }

        assertThat(nameList).hasSameElementsAs(List.of("hello", "world", "my", "name"));
    }
}
