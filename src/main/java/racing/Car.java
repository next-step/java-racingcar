package racing;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Car {

    private final AtomicInteger distance = new AtomicInteger();
    private static final String SKID_MARK = "- ";

    public void move() {
        int random = new Random().nextInt(10);
        if(random >= 4) distance.addAndGet(1);
    }

    public String skidMark() {
        if(distance.intValue() == 0) {
            return SKID_MARK+" \n";
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < distance.intValue(); i += 1) {
            sb.append(SKID_MARK);
        }
        sb.append("\n");
        return sb.toString();
    }

}
