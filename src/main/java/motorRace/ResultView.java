package motorRace;

public class ResultView {
    public static void systemOut(String msg){
        System.out.println(msg);
    }

    public static void systemOut(RacingCar racingCar){
        System.out.println("-".repeat(racingCar.getPosition()));
    }
}
