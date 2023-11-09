package racingCar;

public class Car {
    private String carName;
    private int forwardCnt;

    public Car(String carName){
        checkCarName(carName);
        this.carName = carName;
        this.forwardCnt = 0;
    }

    public Car(String carName, int forwardCnt){
        checkCarName(carName);
        this.carName = carName;
        this.forwardCnt = forwardCnt;
    }

    private void checkCarName(String carName){
        if(carName.length()>5){
            throw new RuntimeException();
        }
    }

    public String getCarName(){
        return carName;
    }

    public int getForwardCnt(){
        return forwardCnt;
    }

    public void addForward(int forwardCnt){
        this.forwardCnt += forwardCnt;
    }
}
