package car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingGameTest {
    private RacingGame racingGame;
    private final InputParser inputParser = new InputParser();
    private static final Integer MOVABLE_NUMBER = 9;
    private static final Integer NON_MOVABLE_NUMBER = 1;
    private static final String DELIMITER = ",";

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(new RandomNumberGenerator());
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "pobi,crong:2", "pobi,crong,honux:3"},delimiter = ':')
    public void 자동차_생성_테스트(String userInput, Integer numberOfCars) {
        assertThat(racingGame.createCars(inputParser.parseUserInputByDelimiter(userInput))).hasSize(numberOfCars);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:pobi"},delimiter = ':')
    public void 게임_진행_후_단독_우승자_포비_식별_과정_테스트(String userInput, String winner) {
        //given
        List<Car> cars = racingGame.createCars(inputParser.parseUserInputByDelimiter(userInput));
        for (Car car : cars) {
            if(car.getCarName().equals(winner)) {
                car.game(MOVABLE_NUMBER);
            } else {
                car.game(NON_MOVABLE_NUMBER);
            }
        }

        //when
        List<String> tiedWinnerCarNames = racingGame.findTiedWinnerCarNames(cars, racingGame.findFinalWinner(cars));

        //then
        assertThat(tiedWinnerCarNames).containsExactly(winner);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:pobi,crong"},delimiter = ':')
    public void 게임_진행_후_공동_우승자_포비_크롱_식별_과정_테스트(String userInput, String winners) {
        //given
        List<Car> cars = racingGame.createCars(inputParser.parseUserInputByDelimiter(userInput));
        List<String> winnerNames = List.of(winners.split(DELIMITER));
        for (Car car : cars) {
            if(winnerNames.contains(car.getCarName())) {
                car.game(MOVABLE_NUMBER);
            } else {
                car.game(NON_MOVABLE_NUMBER);
            }
        }

        //when
        List<String> tiedWinnerCarNames = racingGame.findTiedWinnerCarNames(cars, racingGame.findFinalWinner(cars));

        //then
        assertThat(tiedWinnerCarNames).containsAnyElementsOf(winnerNames);
    }
}
