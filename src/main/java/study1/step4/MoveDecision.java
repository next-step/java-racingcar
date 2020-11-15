package study1.step4;

import java.util.Random;

public class MoveDecision implements Decision {
    Random generator = new Random();
    int MovementNumberArea = 10;
    int StandardNumber = 4;

    public boolean moveDecision(){
        return generator.nextInt(this.MovementNumberArea) >= this.StandardNumber;
    }
}
