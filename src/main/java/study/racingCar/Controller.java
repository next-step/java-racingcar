package study.racingCar;

import static study.racingCar.RandomNumGenerator.getRandomNum;

public class Controller {

    public static void main(String[] args){
        CarRacingGame game = new CarRacingGame();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        StringToIntConverter converter = new StringToIntConverter();
        Car[] cars;
        int tryCount = 0;

        try{
            cars = game.createCarList(inputView.inputCarNames());
            tryCount = converter.converter(inputView.inputTryCount());

            resultView.printResult();
            game.playGame(tryCount, cars);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
