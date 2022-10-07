package racing.core;

import lombok.*;
import racing.RandomUtil;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
public class Car {

    private int distance = 1;

    public Car(int distance) {
        this.distance += distance;
    }

    public int getDistance(){
        return this.distance;
    }

    public void stepAhead(int stepCount){
        this.distance += stepCount;
    }
}
