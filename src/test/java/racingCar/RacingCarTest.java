package racingCar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static racingCar.Car.getNamesFromList;


public class RacingCarTest {


    @Test
    public void 우승자추출하기(){
        String[] result = RacingCarUtil.splitList("pobi,crong,honux");
        assertArrayEquals(new String[]{"pobi", "crong", "honux"}, result);
    }


    @Test
    public void 중복우승자인원수테스트(){
        Car[] carArray= new Car[]{new Car("pobi", 4), new Car("hello", 4),new Car("crong", 3)};
        List<Car> result = Arrays.asList(carArray);
        GameResult gr = new GameResult(result);

        List<Car> aspectList = Arrays.asList(new Car[]{new Car("pobi",4), new Car("hello",4)});
        assertEquals(gr.getWinnerCar().size(), aspectList.size());


    }

    @Test
    public void 이름추출테스트(){
        Car[] carArray= new Car[]{new Car("pobi", 4), new Car("hello", 4)};
        List<Car> result = Arrays.asList(carArray);
        GameResult gr = new GameResult(result);
        List<String> nameList = new ArrayList<String>();
        assertThat(getNamesFromList(result).get(0).equals("pobi"));

    }


}