package carracing.controller;

import carracing.domain.*;
import carracing.exception.CarNameFormatException;
import carracing.view.InputInfo;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

/*
 * CarRacing
 *
 * Version 1.0.0
 *
 * 2021-11-08
 *
 * author jiseok-choi
 */
public class CarRacing {

    public InputInfo racingQuestion() {
        InputView inputView = new InputView();
        inputView.carNameQuestion();
        inputView.tryCountQuestion();
        return new InputInfo(inputView.getCarNames(), inputView.getTryCount());
    }

    public RaceResult racingStart(InputInfo inputInfo) throws CarNameFormatException {

        RaceResult raceResult = new RaceResult();
        ResultView resultView = new ResultView();
        List<Car> carList = new ArrayList<>();

        createCarNameList(inputInfo, carList);

        Cars cars = new Cars(carList);
        for (int i = 0; i < inputInfo.getTryCount(); i++) {
            racing(cars, inputInfo);                 /* 시도 횟수 만큼 주행 */
            resultView.printRacing(cars);            /* 시도 횟수 만큼 출력 */
            raceResult.roundCount++;
        }

        Winners winners = cars.getWinner();
        resultView.printWinner(winners);

        return raceResult;
    }

    private void createCarNameList(InputInfo inputInfo, List<Car> carList) throws CarNameFormatException {
        for (int i = 0; i < inputInfo.getCarCount(); i++) {
            carList.add(new Car(inputInfo.getCarStringList().get(i)));
        }
    }

    public void racing(Cars carList, InputInfo inputInfo) {
        for (int i = 0; i < inputInfo.getCarCount(); i++) {
            carList.get(i).driving(RandomCondition.getCondition());
        }
    }

}
