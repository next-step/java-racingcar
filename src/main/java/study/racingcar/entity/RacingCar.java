package study.racingcar.entity;

public class RacingCar {

    private static final int MOVE_POSSIBLE_NUMBER = 4;
    private int position;
    private final String name;

    public RacingCar(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void oneStep(int number){
        if(movePossible(number)) {
            carMove();
        }
    }

    private boolean movePossible(int number) {
        return number >= MOVE_POSSIBLE_NUMBER;
    }

    private void carMove(){
        this.position += 1;
    }

}
