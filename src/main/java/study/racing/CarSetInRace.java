package study.racing;

public class CarSetInRace {
    private int position;
    private String carName;

    public CarSetInRace(int position, String carName){
        this.position = position;
        this.carName = carName;
    }

    public int getPosition(){
        return position;
    }

    public String getCarName(){
        return carName;
    }
}
