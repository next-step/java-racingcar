package study1.step3;

import java.util.Random;

public class MoveDecision {
    Random generator = new Random();

    boolean moveDecision(){
        return generator.nextInt(10) >= 4;
    }
}
