package racing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 01:39
 */
public class RacingGame {

    public static void main(String[] args) {
        startCarRacing();
    }

    public static void startCarRacing() {
        RacingGameInputView racingGameInputView = new RacingGameInputView();
        CarRace carRace = new CarRace();
        carRace.start(createParticipant(racingGameInputView.inputNumberCars()));
    }

    private static Map<Integer, List<CarNextStep>> createParticipant(int numberOfCars) {
        Map<Integer, List<CarNextStep>> participant = new HashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            participant.put(i, new ArrayList<>());
        }

        return participant;
    }
}
