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

    public String racingNameTxt(){
        return name+" : ";
    }

    public boolean compareDistance(int baseDistance){
        return distance >= baseDistance;
    }

    public int findFartherDistance(int baseDistance){
        if (compareDistance(baseDistance)) {
            return distance;
        }
        return baseDistance;
    }

    public String findMovedMaxDistanceCar(int maxDistance) {
        if(compareDistance(maxDistance)){
            return name;
        }
        return "";
    }

}
