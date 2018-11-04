package racingcar;

public class RacingCar {

    private int position;
    private String name;

    public static final int MOVING_CONDITION = 4;

    public RacingCar(int position, String name){
        this.position = position;
        this.name = name;
    }

    public int move(int random) {
        if(isMoving(random))
            return this.position+=1;

        return this.position;
    }

    private boolean isMoving(int n) {
        return n >= MOVING_CONDITION;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        String str = this.name + " : ";

        for(int i = 0; i < this.position; i++) {
            str += "-";
        }
        return str;
    }
}
