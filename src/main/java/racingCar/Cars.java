package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<String> carList = new ArrayList<>();

    public Cars(int N) {
        for (int i =0; i < N; i++) {
            this.carList.add("-");
        }
    }

}
