package racing.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import racing.RandomUtil;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    private int distance;
    private static final String DEFAULT_MARKER = "-";

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

    private void oneStepAhead(){
        this.distance += 1;
    }
}
