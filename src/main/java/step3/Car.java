package step3;

public class Car {
    
    private int move;
    
    public int getPosition() {
        return this.move;
    }
    
    public void move(boolean isMoveForward) {
        if( isMoveForward ) {
            this.move++;
        }
    }
    
}
