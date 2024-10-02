package step5.uiview;

import step5.car.CarStrategy;
import step5.game.PreparedCarGame;
import step5.message.Message;

import java.util.List;

public class ResultView {

    private final static String DISTANCE_DISPLAY = "-";
    private final static String CAR_NAME_DISPLAY = " : ";

    private final static String COMMA = ", ";
    private final static String WINNER_TARGET = "{winner}";

    //현재 레이싱결과를 출력한다.
    public void resultView(PreparedCarGame preparedCarGame) {
        System.out.println(Message.RESULT_MESSAGE.message());
        raceSituationResultView(preparedCarGame.getRaceSituation());
        winnerView(preparedCarGame.winnerRace());
    }

    //현재 레이싱 우승자를 출력한다.
    private void winnerView(List<String> winner) {
        System.out.println(Message.WINNER.message().replace(WINNER_TARGET, String.join(COMMA, winner)));
    }

    private void raceSituationResultView(List<List<CarStrategy>> raceSituation) {
        for (List<CarStrategy> carStrategy : raceSituation) {
            carSituationResultView(carStrategy);
            System.out.println();
        }
    }

    private void carSituationResultView(List<CarStrategy> carStrategies) {
        for (CarStrategy carStrategy : carStrategies) {
            System.out.println(carStrategy.getCarName() + CAR_NAME_DISPLAY + DISTANCE_DISPLAY.repeat(carStrategy.getDistance()));
        }
    }
}
