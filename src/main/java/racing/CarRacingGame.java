package racing;

import java.io.InputStream;
import java.util.*;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-27 23:59
 */
public class CarRacingGame implements RacingGame {

    private static final Random random = new Random();
    private static final int RANDOM_VALUE_AMOUNT = 0;
    private static final Map<Integer, List<CarNextStep>> participantCar = new HashMap<>();

    private final int numberOfCars;
    private final int numberOfRound;
    private final RacingGameInputView racingGameInputView;
    private final RacingGameResultView racingGameResultView;

    public CarRacingGame(InputStream in) {
        racingGameInputView = new RacingGameInputView(in);
        racingGameResultView = new RacingGameResultView();
        numberOfCars = racingGameInputView.getNumberOfCars();
        numberOfRound = racingGameInputView.getNumberOfRound();
        putParticipantCarMap(numberOfCars);
    }

    @Override
    public void start() {
        for (int round = 0; round < numberOfRound; round++) {
            for (int car = 0; car < numberOfCars; car++) {
                move(car, CarNextStep.isMoved(getRandomIntValue()));
            }
            racingGameResultView.printResult(participantCar);
        }
    }

    @Override
    public int getRandomIntValue() {
        return random.nextInt(10);
    }

    @Override
    public int getParticipantCarCount() {
        return numberOfCars;
    }

    private void putParticipantCarMap(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            participantCar.put(i, new ArrayList<>());
        }
    }

    private void move(int carNumber, CarNextStep nextStep) {
        participantCar.get(carNumber).add(nextStep);
    }
}
