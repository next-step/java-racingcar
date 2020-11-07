package study1.step3;

import java.util.Random;

public class MoveDecision implements Decision{
    Random generator = new Random();

    public boolean moveDecision(){
        return generator.nextInt(10) >= 4;
    }
}
