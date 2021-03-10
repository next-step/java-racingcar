package study.step3;

public class RandomRaceCar implements Car{
    private static final int START_POSITION = 1;
    private String carName;
    private int position;
    public RandomRaceCar(String carName){
        this.carName = carName;
        this.position = START_POSITION;
    }
    @Override
    public void move(boolean condition){
        if(condition){
            position++;
        }
    }
    @Override
    public int getPosition(){
        return position;
    }
    @Override
    public String getCarName(){
        return carName;
    }
}
