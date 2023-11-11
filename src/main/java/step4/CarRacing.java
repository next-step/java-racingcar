package step4;

import step4.model.Car;
import step4.model.CarRacingPlay;
import step4.model.ChampionCarsDto;
import step4.model.MyRandomValueGenerator;
import step4.view.*;

import java.util.List;
import java.util.Scanner;

public class CarRacing {


    private static final ScannerInterface myScanner = new MyScanner(new Scanner(System.in));

    public static void main(String[] args) {

        CarRacingInputView carRacingInputView = new CarRacingInputView(myScanner);
        InputDto inputDto = carRacingInputView.inputRacingCondition();


        ResultView resultView = new ResultView();
        resultView.printRacingResultStartText();

        CarRacingPlay carRacingPlay = new CarRacingPlay(new MyRandomValueGenerator(), inputDto.getCarNames());

        for (int i = 0; i < inputDto.getCarRacingChance(); i++) {
            List<Car> cars = carRacingPlay.raceOneCycle();
            resultView.printRacingStatus(cars);
        }

        ChampionCarsDto champions = carRacingPlay.findChampions();
        resultView.printChampionCars(champions);
    }
}
