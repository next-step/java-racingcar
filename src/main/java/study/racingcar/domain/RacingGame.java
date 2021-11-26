package study.racingcar.domain;


import study.racingcar.dto.RequestDto;
import study.racingcar.dto.ResponseDto;
import study.racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    private static final String SEPARATOR = ",";

    private final Cars cars;
    private final TryRound tryRound;

    public RacingGame(RequestDto requestDto){
        this(requestDto.getCarNames(), requestDto.getTryRound());
    }

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

    public Cars getResult() {
        return cars.getResultCars();
    }

    public Cars playRound(MoveStrategy moveStrategy) {
        tryRound.nextRound();
        return new Cars(cars.endRound(moveStrategy));
    }

    public List<Car> getWinners() {
        return cars.getWinner();
    }

    public boolean moreRound(){
        return tryRound.moreRound();
    }

    public ResponseDto playGames(MoveStrategy moveStrategy){
        List<Cars> resultGames = new ArrayList<>();
        while(moreRound()){
            resultGames.add(playRound(moveStrategy));
        }
        return new ResponseDto(resultGames, getWinners());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars) && Objects.equals(tryRound, that.tryRound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryRound);
    }
}
