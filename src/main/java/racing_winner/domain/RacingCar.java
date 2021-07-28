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

    public String initPrintTxt(){
        return name+" : ";
    }

    public String drawDistance(String code){
        String distanceLine = initPrintTxt();
        for(int i = 0; i < distance; i++){
            distanceLine+=code;
        }
        return distanceLine;
    }

    public int compareDistance(int baseDistance){
        if (distance > baseDistance) {
            return distance;
        }
        return baseDistance;
    }

    public String findMovedMaxDistance(int maxDistance, String winner) {
        if(distance == maxDistance){
            winner+= name;
        }
        return winner;
    }

}
