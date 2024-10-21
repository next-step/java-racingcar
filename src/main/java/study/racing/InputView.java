package study.racing;

import study.racing.constants.RacingMessage;
import study.racing.domain.CarRaceInput;
import study.validation.CountValidator;
import study.validation.NameValidator;
import study.validation.RaceInputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public CarRaceInput readInput() {

        System.out.println(RacingMessage.CAR_COUNT.getMsg());
        String carCount = scanner.nextLine();

        System.out.println(RacingMessage.TRY_COUNT.getMsg());
        String roundCount = scanner.nextLine();

        int car = 0;
        int round = 0;

        RaceInputValidator raceInputValidator = new CountValidator();

        boolean isCarInputMatch = raceInputValidator.validate(carCount);
        boolean isTryInputMatch = raceInputValidator.validate(roundCount);
        if(isCarInputMatch && isTryInputMatch) {
            car = Integer.parseInt(carCount);
            round = Integer.parseInt(roundCount);
        }
        return new CarRaceInput(car, round);
    }

    public CarRaceInput collectUserInput() {

        String carName = validCarName();
        int roundCount = validRound();

        int round = 0;
        CarRaceInput carRaceInput = null;

        if (carName != null && roundCount >= 1) {
            List<String> carNames = Arrays.stream(carName.trim().split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            round = roundCount;
            carRaceInput = new CarRaceInput(carNames, carNames.size(), round);
        }

        return carRaceInput;
    }

    private String validCarName() {

        System.out.println(RacingMessage.CAR_NAME.getMsg());
        String carName = scanner.nextLine();

        RaceInputValidator participantInputValidator = new NameValidator();
        if (!participantInputValidator.validate(carName)) {
            return null;
        }

        return carName;
    }

    private int validRound() {

        System.out.println(RacingMessage.TRY_COUNT.getMsg());
        String roundCount = scanner.nextLine();

        RaceInputValidator roundInputValidator = new CountValidator();
        if (!roundInputValidator.validate(roundCount)) {
            return 0;
        }

        return Integer.parseInt(roundCount);
    }
}
