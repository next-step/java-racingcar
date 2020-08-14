package step3;

public class Car {
	
    private static final int MIN_MOVE_POWER = 4;
	
    private int position;
	
    public int getPosition() {
        return position;
    }
    
    public void tryToMove(int power) {
        if (validatePowerRange(power)) {
            this.position++;
        }
    }

    private boolean validatePowerRange(int power) {
    	return power >= MIN_MOVE_POWER;
    }
    
}