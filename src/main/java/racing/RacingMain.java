package racing;

public class RacingMain {
    public static void main(String[] args) {
//        String carNames[] = InputView.getNames();
//        int tryTime = InputView.inputTryTime();
        String carNames[] ={"m1", "m2"};
        Racing racing = new Racing(carNames);
        ResultView resultView = new ResultView();
        resultView.executeResult();
        for(int i = 0 ; i< 3 ; i++){
            resultView.printMoveCar(racing.onceMove());
        }
//        racing.whoIsWin();
//        racing.startRace();
//        ResultView.printCars(racing.getRacingCar());
    }
}
