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

        System.out.println(RacingMessage.CAR_NAME.getMsg());
        String carName = scanner.nextLine();

        System.out.println(RacingMessage.TRY_COUNT.getMsg());
        String roundCount = scanner.nextLine();

        int round = 0;
        CarRaceInput carRaceInput = null;

        RaceInputValidator roundInputValidator = new CountValidator();
        RaceInputValidator participantInputValidator = new NameValidator();

        boolean isRoundInputMatch = roundInputValidator.validate(roundCount);
        boolean isParticipantInputMatch = participantInputValidator.validate(carName);
        if(isRoundInputMatch && isParticipantInputMatch) {
            List<String> carNames = Arrays.stream(carName.trim().split(","))
                                        .map(String::trim)
                                        .collect(Collectors.toList());
            round = Integer.parseInt(roundCount);
            carRaceInput = new CarRaceInput(carNames, carNames.size(), round);
        }
        return carRaceInput;
    }
}
