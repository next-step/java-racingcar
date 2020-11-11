package study.racing;

public class SingleRecord {
    private int position;
    private String carName;

    public SingleRecord(int position, String carName){
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
