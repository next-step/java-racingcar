package step5;


import step5.controller.CarRacingController;
import step5.controller.ChampionCarsDto;
import step5.controller.RacingResultDto;
import step5.model.CarRacingPlay;
import step5.model.MyRandomValueGenerator;
import step5.view.*;

import java.util.Scanner;

public class CarRacing {


    private static final ScannerInterface myScanner = new MyScanner(new Scanner(System.in));

    public static void main(String[] args) {

        CarRacingInputView carRacingInputView = new CarRacingInputView(myScanner);
        InputDto inputDto = carRacingInputView.inputRacingCondition();


        ResultView resultView = new ResultView();

        // 자동차 생성
        CarRacingController carRacingController = new CarRacingController(new CarRacingPlay(new MyRandomValueGenerator()));
        carRacingController.makeRacingCarList(inputDto.getCarNames());

        // 자동차 경주 진행 및 결과 출력
        RacingResultDto racingResultDto = carRacingController.race(inputDto.getCarRacingChance());
        resultView.printRacingResult(racingResultDto);


        // 최종 우승자 출력
        ChampionCarsDto championCarsDto = carRacingController.findChampions();
        resultView.printChampionCars(championCarsDto);
    }
}
