import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Computer {

    private final int DRIVING_CONDITION = 4;

    public void remoteControl(Car car) {
        if (isRun())
            car.run();
        car.stop();
    }

    private boolean isRun() {
        ArrayList<Integer> range = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(range);
        return range.get(0) >= DRIVING_CONDITION;
    }
}
