package racingcar.model;

public class Car {
    private final StringBuilder sb = new StringBuilder();

    private String carName;
    private int distance = 0;

    public Car(String carName) {
        if(isOverFive(carName)){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.carName = carName;
        sb.append(carName + " : ");
    }

    public String getCarName() {
        return carName;
    }

    private boolean isOverFive(String carName) {
        return carName.length() > 6;
    }

    public boolean isMove(MovingStrategy movingStrategy){
        if(movingStrategy.movable()){
            distance += 1;
            sb.append("-");
            return true;
        }
        return false;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getShowDistance(){
        return sb.toString();
    }
}
