package racinggame.domain;


import com.sun.javafx.beans.IDProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("Cars 생성자 테스트")
    @Test
    public void carsConstructorTest() {
        String[] carNames = {"a", "b"};
        Cars cars = new Cars(carNames);
        List<Car> carList = cars.getCars();
        Assertions.assertThat(2).isEqualTo(carList.size());

    }

    @DisplayName("Cars 움직임 테스트")
    @Test
    public void moveCarsTest() {
        String[] carNames = {"a", "b"};
        Cars cars = new Cars(carNames);
        List<Integer> randomValue = Arrays.asList(1, 5);
        cars.move(randomValue);
        Assertions.assertThat(cars.getCars().get(0).getLocation()).isEqualTo(0);
        Assertions.assertThat(cars.getCars().get(1).getLocation()).isEqualTo(1);

    }

}
