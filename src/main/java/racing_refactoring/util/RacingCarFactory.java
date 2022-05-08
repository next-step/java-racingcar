package racing_refactoring.util;

import racing_refactoring.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {
    private static final int PARTICIPANT = 2;
    private static final String SPILT_COMMA_AND_TRIM = "\\s*,\\s*";

    public static List<RacingCar> initRacing(String names) {
        return asList(splitNames(names));
    }

    private static String[] splitNames(String names) {
        String[] splitNames = names.split(SPILT_COMMA_AND_TRIM);
        if (invalidParticipantsCount(splitNames.length)) {
            throw new IllegalArgumentException("참가하는 자동차는 두 대 이상이어야 합니다.");
        }
        return splitNames;
    }

    private static List<RacingCar> asList(String[] splitNames) {
        List<RacingCar> cars = new ArrayList<>();
        for (String name : splitNames) {
            cars.add(new RacingCar(name));
        }
        return cars;
    }

    private static boolean invalidParticipantsCount(int participantCounts) {
        return participantCounts < PARTICIPANT;
    }
}
