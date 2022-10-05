package racing.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import racing.RandomUtil;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Car {
    private int distance;
    private static final String DEFAULT_MARKER = "-";
    private static int STEP_COUNT = 1;

    public static List<Car> makeCarList(int size) {
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            carList.add(new Car());
        }
        return carList;
    }

    public String go() {
        return DEFAULT_MARKER.repeat(Math.max(0, distance));
    }

    private void stepAhead(){
        this.distance += STEP_COUNT;
    }

    public int roll() {
        int randomNum = RandomUtil.getRandomNumUnder10();
        if(randomNum >= 4){
            this.distance += STEP_COUNT;
            return 1;
        }
        return 0;
    }
}
