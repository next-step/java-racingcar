package RacingCar;

import java.util.Random;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carList = inputView.carNameList();
        int round = inputView.round();

        if(Validate.emptyCheck(carList)){
            return;
        }



        Racing racing = new Racing(carList, round);
        ResultView resultView = new ResultView();
        RandomNumber randomNumber = new RandomNumber();

        resultView.resultView();
//        for (int i = 0; i < racing.getRound(); i++) {
//            racing.round(randomNumber.randomList(carCount));
//            resultView.roundView(racing.getCarList());
//        }
    }
}
