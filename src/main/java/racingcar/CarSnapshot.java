package racingcar;

public class CarSnapshot {
    private int distance = 1;

    public CarSnapshot(Car car) {
        this.distance = car.getDistance();
    }

    public String getDistanceToUI(){
        String result = "";
        for(int i=0; i < distance; i++){
            result += "-";
        }
        return result;
    }
}
