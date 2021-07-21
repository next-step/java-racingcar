package racing;

public class CarModel {

    private int carNumber;
    private String raceDistance;

    public CarModel(int carNumber) {
        this.carNumber = carNumber;
        this.raceDistance = "";
    }

    public void carRacingAct(boolean flag){
        if(flag){
            raceDistance += "-";
        }
        System.out.println(raceDistance);
    }

}
