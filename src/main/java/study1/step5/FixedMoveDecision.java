package study1.step5;


public class FixedMoveDecision implements Decision {
    int inputNumber;

    public FixedMoveDecision(int inputNumber){
        this.inputNumber = inputNumber;
    }

    public boolean moveDecision(){
        return this.inputNumber >= 4;
    }
}
