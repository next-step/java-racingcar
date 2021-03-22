package RacingGame;

public class ResultView {

    public static void viewResult(Car racingCar){

        int racingCarAt = racingCar.isAt();
        String printValue = new String(new char[racingCarAt]).replace("\0", "-");
        System.out.println(printValue);

    }

}
