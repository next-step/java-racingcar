package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.utils.RandomGeneratorImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.dto.RaceResultDTO;
import racingcar.dto.RunResultDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private static final int MAX_RANGE = 10;
    private static final String SPLIT_REGEX = ",";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = InputView.getCarNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(" + SPLIT_REGEX + ")를 기준으로 구분) ", SPLIT_REGEX, scanner);
        int tryCount = InputView.getTryCount("시도할 회수는 몇 회 인가요? ", scanner);

        System.out.println();

        RacingGame racingGame = new RacingGame(names, new RandomGeneratorImpl(MAX_RANGE));
        List<Car> cars = racingGame.getCars();

        List<RaceResultDTO> racingGameResult = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            RaceResultDTO raceResultDTO = new RaceResultDTO(new ArrayList<>());
            for (Car car : cars) {
                racingGame.run(car);
                raceResultDTO.getRunResults()
                    .add(new RunResultDTO(car.getName(), OutputView.generateRaceResultString(car)));
            }
            racingGameResult.add(raceResultDTO);
        }

        OutputView.printRacingGameResult(racingGameResult);
        System.out.println(OutputView.generateWinnersString(cars));
    }
}
