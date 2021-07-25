package racing.view;

import racing.domain.car.entity.BasicCar;
import racing.domain.car.entity.Cars;
import racing.domain.car.vo.Name;
import racing.domain.car.vo.fuel.RandomFuel;
import racing.domain.game.entity.RacingGame;
import racing.domain.game.vo.turn.Turns;
import racing.exception.InvalidInputException;
import util.StringUtils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static racing.view.DosInputView.Text.*;

public class DosInputView implements InputView {
    private final Scanner scanner;
    private static final String NAME_DELIMITER = ",";

    public DosInputView() {
        this.scanner = new Scanner(System.in);
    }

    private int inputNumber(Text guideText) {
        String input = inputLine(guideText);
        if (!StringUtils.isNumber(input))
            throw new InvalidInputException("숫자만 입력 해주세요.");

        return Integer.parseInt(input);
    }

    private String inputLine(Text guideText) {
        System.out.println(guideText.toString());

        return scanner.nextLine();
    }

    private Cars inputCars() {
        String strNames = inputLine(INPUT_CAR_NAMES);
        String[] strNameSplitValues = strNames.split(NAME_DELIMITER);

        return new Cars(
                Arrays.stream(strNameSplitValues)
                        .map(Name::new)
                        .map(BasicCar::new)
                        .collect(Collectors.toSet())
        );
    }

    public Turns inputTurns() {
        int turnSize = inputNumber(INPUT_TURN_SIZE);

        return new Turns(turnSize);
    }

    @Override
    public RacingGame inputRacingGame() {
        Cars cars = inputCars();
        Turns turns = inputTurns();
        return new RacingGame(turns, cars, new RandomFuel());
    }

    protected enum Text {
        INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요 (이름은 '" + NAME_DELIMITER + "'를 기준으로 구분)."),
        INPUT_TURN_SIZE("시도할 회수는 몇 회 인가요?");

        private final String text;

        Text(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
