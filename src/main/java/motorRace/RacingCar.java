package motorRace;


public class RacingCar {
    private int position;

    public RacingCar() {
        this.position = 0;
    }

    public int move() {
        return position++;
    }

    public int getPosition(){
        return position;
    }
}
