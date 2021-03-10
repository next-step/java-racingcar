package study.step3;

public class Car extends Moving{
    private static final Integer START_POSITION = 1;
    private String carName;
    private int position;
    public Car(String carName){
        this.carName = carName;
        this.position = START_POSITION;
    }

    public int getPosition(){
        return position;
    }
    public String getCarName(){
        return carName;
    }

}
