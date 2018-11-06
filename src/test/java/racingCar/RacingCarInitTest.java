package racingCar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static racingCar.RacingCarWinner.sortingList;

public class RacingCarInitTest {


    @Test
    public void moveCount(){
        int result = Car.move(7);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void changeCarPosition(){
        int[] result = {0,0,0};
        result[0] += Car.move(6);
        result[1] += Car.move(3);
        result[2] += Car.move(8);

        assertArrayEquals(new int[]{1,0,1},result);
    }

    @Test
    public void 자동차나누기(){
        String[] result = RacingCarUtil.splitList("pobi,crong,honux");
        assertArrayEquals(new String[]{"pobi", "crong", "honux"}, result);
    }

    @Test
    public void 정렬(){
        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car("pobi",6));
        carList.add(new Car("phlo",4));
        carList.add(new Car("good",5));
        carList.add(new Car("crong",5));
        List<Car> result = sortingList(carList);

        List<Car> notSortingList = new ArrayList<Car>();
        notSortingList.add(new Car("phlo",4));
        notSortingList.add(new Car("pobi",6));
        notSortingList.add(new Car("good",5));
        notSortingList.add(new Car("crong",5));
        List<Car> Realresult = sortingList(carList);

        assertThat(result).isEqualTo(Realresult);

    }

    @Test
    public void 중복우승자리스트(){
        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car("pobi",6));
        carList.add(new Car("phlo",4));
        carList.add(new Car("good",6));
        carList.add(new Car("crong",5));
        List<Car> result = RacingCarWinner.winnerList(sortingList(carList));

        List<Car> compareList = new ArrayList<Car>();
        compareList.add(new Car("pobi",6));
        compareList.add(new Car("good",6));

        Car.getResult(result).equals(Car.getResult(compareList));

    }


}