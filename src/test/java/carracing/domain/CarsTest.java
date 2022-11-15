package carracing.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarsTest {
    @Test
    public void racingTest(){
        List<Car> carList = Arrays.asList(new Name("name1"),new Name("name2")).stream()
                .map(Car::new)
                .collect(Collectors.toList());
        Cars cars = new Cars(carList);

        NumberGenerator numberGenerator = new MovableNumberGenerator();
        cars.racing(numberGenerator);
        assertAll(
                ()->assertThat(carList.get(0).getPosition()).isEqualTo(1),
                ()->assertThat(carList.get(1).getPosition()).isEqualTo(1)
        );
    }

    @Test
    public void duplicatedTest(){
        List<Car> carList = Arrays.asList(new Name("name1"),new Name("name1")).stream()
                .map(Car::new)
                .collect(Collectors.toList());

        assertThatThrownBy(()->new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    public void getWinnerTest(){
        List<Car> carList = Arrays.asList(new Name("name1"),new Name("name2")).stream()
                .map(Car::new)
                .collect(Collectors.toList());
        Cars cars = new Cars(carList);

        NumberGenerator numberGenerator = new MovableNumberGenerator();
        cars.getCarList().get(0).move(numberGenerator);

        //Test 하기가 어렵다.....어떻게 하는 걸까?
        assertThat(cars.getWinners()).containsExactly(cars.getCarList().get(0));
    }

    @Test
    public void getMaxPostionTest() throws NoSuchMethodException {
        List<Car> carList = Arrays.asList(new Name("name1"),new Name("name2")).stream()
                .map(Car::new)
                .collect(Collectors.toList());
        Cars cars = new Cars(carList);

        NumberGenerator numberGenerator = new MovableNumberGenerator();
        cars.getCarList().get(0).move(numberGenerator);
        Method method = cars.getClass().getDeclaredMethod("getMaxPosition");
        method.setAccessible(true);

        try {
            assertThat(method.invoke(cars)).isEqualTo(1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
