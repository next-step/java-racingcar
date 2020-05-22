package game.ui;

import game.Car;
import game.CarName;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleRacingGameResultView implements RacingGameResultView {

    private static final char FOOTPRINT = '-';
    private static final String ANNOUNCE_WINNER_COMMENT_FORMAT = "%s가 최종 우승했습니다.";

    @Override
    public void printRound(int round) {
        System.out.println(String.format("-ROUND %d-", round));
    }

    @Override
    public void printResult(Car car) {
        char[] chars = new char[car.getPosition()];
        Arrays.fill(chars, FOOTPRINT);
        System.out.println(String.format("%s : %s", car.getCarName(), new String(chars)));
    }

    @Override
    public void announceWinner(List<Car> carList) {
        String carNameString = carList.stream().map(Car::getCarName).collect(Collectors.joining(", "));
        System.out.println(String.format(ANNOUNCE_WINNER_COMMENT_FORMAT, String.join(", ", carNameString)));
    }
}
