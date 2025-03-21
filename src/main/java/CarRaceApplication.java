import java.util.List;

public class CarRaceApplication {
    public static void main(String[] args) {
        InputView input = new InputView();
        int carCount = input.getCarCount();
        int runCount = input.getRunCount();

        CarRace carRace = new CarRace(carCount, runCount);
        List<List<Integer>> result = carRace.run();

        ResultView output = new ResultView();
        output.print(result);
    }
}
