package racingCar.controller;

import racingCar.domain.*;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

public class CarRacingGame {
    public static void main(String[] args) {
        CarNames carNames = InputView.getCarNamesFromUser();
        int rounds = InputView.getRoundsCountFromUser();

        Cars cars = CarFactory.createCars(carNames);

        RandomMoveStrategy randomMoveCondition = new RandomMoveStrategy(new Random());

        RacingGame racingGame = new RacingGame(cars,randomMoveCondition);


        List<List<RoundStatusDTO>> roundResults = new ArrayList<>();
        for(int i=0; i<rounds; i++) {
            racingGame.playRound();
            roundResults.add(convertToRoundDTOs(racingGame.getCars()));
            ResultView.printStatus(roundResults.get(i));
            ResultView.printEmptyLine();
        }

        List<RoundStatusDTO> winners = convertToRoundDTOs(racingGame.findWinners());
        ResultView.printWinners(winners);
    }

    private static List<RoundStatusDTO> convertToRoundDTOs(List<Car> cars) {
        return cars.stream()
                .map(RoundStatusDTO::of)
                .collect(Collectors.toList());
    }
}
