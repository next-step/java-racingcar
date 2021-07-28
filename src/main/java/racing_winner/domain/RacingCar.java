package racing_winner.domain;

public class RacingCar {

    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
    }

    public void move(){
        distance++;
    }

}
