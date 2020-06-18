package step3;

public class RacingCar {
    private int position = 0;

    public int currentPosition(){
        return position;
    }

    public int move(){
        return position++;
    }
}
