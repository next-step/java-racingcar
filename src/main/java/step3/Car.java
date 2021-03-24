package step3;

public class Car {
    
    private int move;
    
    public int position() {
        return this.move;
    }
    
    public void move() {
        if( RacingCondition.isMoveForward() ) {
            this.move++;
        }
    }
    
}
