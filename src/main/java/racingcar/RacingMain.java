package racingcar;

public class RacingMain {
    public static void main(String[] args){
//        int carNum = InputView.carNum();
//        int tryNum = InputView.tryTime();

//        Racing racing = new Racing(carNum, tryNum);
        Racing racing = new Racing(2, 4);
        ResultView resultView = racing.startRace();
        resultView.results();
    }
}
