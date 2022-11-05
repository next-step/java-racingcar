package carracing.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    public void racingTest(){
        List<Name> nameList = Arrays.asList(new Name("name1"),new Name("name2"));
        Cars cars = new Cars(nameList);

        Cars expectedCarList = new Cars(nameList,1);

        NumberGenerator numberGenerator = new MovableNumberGenerator();
        cars.racing(numberGenerator);
        assertThat(cars).isEqualTo(expectedCarList);
    }

    @Test
    public void duplicatedTest(){
        List<Name> nameList = Arrays.asList(new Name("name1"),new Name("name1"));

        assertThatThrownBy(()->new Cars(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    public void getWinnerTest(){
        List<Name> nameList = Arrays.asList(new Name("name1"),new Name("name2"));
        Cars cars = new Cars(nameList);
        NumberGenerator numberGenerator = new MovableNumberGenerator();
        cars.getCarList().get(0).move(numberGenerator);

        //Test 하기가 어렵다.....어떻게 하는 걸까?
        assertThat(cars.getWinners()).containsExactly(cars.getCarList().get(0));
    }

    @Test
    public void getMaxPostionTest() throws NoSuchMethodException {
        List<Name> nameList = Arrays.asList(new Name("name1"),new Name("name2"));
        Cars cars = new Cars(nameList);
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
