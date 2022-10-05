package racing.core;

import lombok.*;
import racing.RandomUtil;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class Car {

    private int distance = 1;
    private static final String DEFAULT_MARKER = "-";
    private static final int STEP_COUNT = 1;

    public Car(int distance) {
        this.distance += distance;
    }

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
            stepAhead();
            return 1;
        }
        return 0;
    }
}
