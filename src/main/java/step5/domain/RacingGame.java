package step5.domain;

import step5.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {

    public static final String NAME_DELIMITER = ",";
    private final List<Car> cars;
    private int tryCount;
    private List<RacingRecords> racingRecordsStorage;


    public RacingGame(String names, int tryCount){
        nullValidation(names);
        tryCountValidation(tryCount);

        this.cars = initCars(names);
        this.tryCount = tryCount;
        this.racingRecordsStorage = new ArrayList<>();
    }

    private void tryCountValidation(int tryCount) {
        if(tryCount < 1){
            throw new IllegalStateException("시도 횟수는 1이상이어야 합니다.");
        }
    }

    public RacingGame(List<Car> cars, int tryCount){
        validateCars(cars);
        tryCountValidation(tryCount);

        this.cars = cars;
        this.tryCount = tryCount;
        this.racingRecordsStorage = new ArrayList<>();
    }

    private void validateCars(List<Car> cars) {

        if(Objects.isNull(cars)){
            throw new IllegalStateException("등록된 차량이 없습니다.");
        }

        if(cars.size() == 0){
            throw new IllegalStateException("등록된 차량이 없습니다.");
        }
    }


    private List<Car> initCars(String names) {
        return Arrays.asList(names.split(NAME_DELIMITER))
                .stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    private void nullValidation(String names) {
        if(Objects.isNull(names)){
            throw new IllegalStateException("자동차 이름을 입력해주세요");
        }
    }


    public void race(MoveStrategy strategy) {

        checkRacingEnd();

        moveCars(strategy);

        saveRacingRecords();

        this.tryCount--;
    }

    private void moveCars(MoveStrategy strategy) {
        this.cars.forEach(car -> car.move(strategy));
    }

    private void saveRacingRecords() {
        List<RacingRecord> raceResult = this.cars.stream()
                .map(car -> car.racingRecord())
                .collect(Collectors.toList());
        this.racingRecordsStorage.add(new RacingRecords(raceResult));
    }

    private void checkRacingEnd() {
        if(isEnd()){
            throw new IllegalStateException("racing이 종료되었습니다.");
        }
    }

    public RacingRecords nthRacingRecords(int nth) {
        int index = nth - 1;
        return this.racingRecordsStorage.get(index);
    }

    public boolean isEnd(){
        return this.tryCount == 0;
    }


    public List<RacingRecords> getRacingRecordsStorage() {
        return this.racingRecordsStorage;
    }

    public List<String> winners() {
        int lastRacingIndex = this.racingRecordsStorage.size() - 1;
        RacingRecords racingRecords = this.racingRecordsStorage.get(lastRacingIndex);

        return racingRecords.firstRacingCars();
    }
}
