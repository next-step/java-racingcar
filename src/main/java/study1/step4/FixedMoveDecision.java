package study1.step4;


public class FixedMoveDecision implements Decision {
    // test용 Class
    int inputNumber;

    public FixedMoveDecision(int inputNumber){
        this.inputNumber = inputNumber;
    }

    public boolean moveDecision(){
        return this.inputNumber >= 4;
    }
}
