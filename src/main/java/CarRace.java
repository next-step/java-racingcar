import java.util.Random;

public class CarRace {

    ResultView resultView = new ResultView();

    public void start(int cars, int turns) {
        StringBuilder[] carArray = initializeArray(cars);

        for (int i = 0; i < turns; i++) {
            goOrStay(carArray, cars);
            resultView.printEndOfTurn();
        }
    }

    static StringBuilder[] initializeArray(int length) {
        StringBuilder[] sb = new StringBuilder[length];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        return sb;
    }

    private void goOrStay(StringBuilder[] carArray, int cars) {
        Random random = new Random();

        for (int i = 0; i < cars; i++) {
            if (random.nextInt(10) > 3) {
                carArray[i] = carArray[i].append("-");
            }
            resultView.printResultOfTurn(carArray[i]);
        }
    }

}
