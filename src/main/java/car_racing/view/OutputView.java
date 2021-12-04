package car_racing.view;

import car_racing.model.Car;
import car_racing.model.CarsForGame;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String OUT_MESSAGE_WINNER_ANNOUNCE_PHRASE = "(이)가 최종 우승했습니다.";
    private static final String CAR_MOVE_SIGNAL = "-";
    private static final String NAME_SEPARATOR = " : ";
    private static final String NAME_SEPARATOR_FOR_WINNERS = ", ";
    private static final String ONE_ROUND_ENDS_SIGNAL = "\n";
    private static final int FIRST_ROUND = 0;

    public void showCarRacingGameResult(CarsForGame carsForGame, int round) {
        if (round == FIRST_ROUND) {
            System.out.println(OUT_MESSAGE_WINNER_ANNOUNCE_PHRASE);
        }

        StringBuilder result = new StringBuilder();

        for(Car car : carsForGame.getCars()) {
            result.append(buildCarOutput(car));
        }

        System.out.println(result.toString());
    }

    public StringBuilder buildCarOutput(Car car) {
        StringBuilder output = new StringBuilder();

        output.append(car.getStringName()).append(NAME_SEPARATOR);
        output.append(buildPositionOutput(car));

        return output;
    }

    public StringBuilder buildPositionOutput(Car car) {
        StringBuilder output = new StringBuilder();

        for(int position = 0; position < car.getIntPosition(); position ++) {
            output.append(CAR_MOVE_SIGNAL);
        }
        output.append(ONE_ROUND_ENDS_SIGNAL);

        return output;
    }

    public void showWinners(List<Car> winners) {
        List<String> winnersName = new ArrayList<>();

        for(Car car: winners) {
            winnersName.add(car.getStringName());
        }

        System.out.println(
                String.join(NAME_SEPARATOR_FOR_WINNERS, winnersName)
              + OUT_MESSAGE_WINNER_ANNOUNCE_PHRASE
        );

    }

}
