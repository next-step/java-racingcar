package study.racingcar.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String SEPARATOR = ",";
    private static final String WHITE_SPACE = " ";
    private static final String END_RESULT_MESSAGE = "\n";

    private final Cars cars;
    private final TryRound tryRound;

    public RacingGame(String carNames, int tryRound) {
        this.cars = initCars(carNames);
        this.tryRound = new TryRound(tryRound);
    }

    private Cars initCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        validateCarNames(carNames);
        String[] names = carNames.split(SEPARATOR);
        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    private void validateCarNames(String param){
        if(Objects.isNull(param) || param.isEmpty()){
            throw new IllegalArgumentException("자동차 명칭이 정상적이지 않습니다.");
        }
    }

    public String getResult() {
        String roundResult = "";
        for(int i =0; i < tryRound.getTryRound(); i++){
            cars.startRound();
            roundResult += cars.getResult() + END_RESULT_MESSAGE;
        }
        return roundResult;
    }

    public String getWinners() {
        return cars.getWinner().stream()
                .map(Car::getName)
                .collect(Collectors.joining(SEPARATOR + WHITE_SPACE));
    }


}
