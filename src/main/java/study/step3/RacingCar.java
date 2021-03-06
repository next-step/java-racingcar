package study.step3;

public class RacingCar {

    static final int MOVE_POSSIBLE_NUMBER = 4;

    private int position = 0;

    public int getPosition() {
        return position;
    }

    public boolean movePossible(int number) {
        return number >= MOVE_POSSIBLE_NUMBER;
    }

    public void carMove(){
        this.position += 1;
    }

    public void oneStep(int number){
        if(movePossible(number)) {
            carMove();
        }
    }
}
