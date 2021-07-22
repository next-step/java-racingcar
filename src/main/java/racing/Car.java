package racing;

public class Car {

    private int carNumber;
    private String raceDistance;

    public Car(int carNumber) {
        this.carNumber = carNumber;
        this.raceDistance = "";
    }

    public String carRacingAct(boolean flag) {
        if (flag) {
            raceDistance += "-";
        }
        System.out.println(raceDistance);
        return raceDistance;
    }

}
