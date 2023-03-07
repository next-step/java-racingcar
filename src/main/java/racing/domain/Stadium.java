package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Stadium {
    private final List<Car> cars;
    private final int totalRound;
    private final StadiumMoveOption stadiumMoveOption;

    private int round;

    // 이름리스트를 초기값으로 받는 버전
    public Stadium(String names, int totalRound){
        this(initCars(names),
                totalRound,
                new RandomStadiumMoveOptionImpl());
    }

    // 차 리스트를 초기로 받는 버전
    public Stadium(List<Car> cars, int totalRound, StadiumMoveOption stadiumMoveOption){
        this.cars = cars;
        this.totalRound = totalRound;
        this.stadiumMoveOption = new RandomStadiumMoveOptionImpl();

        this.round = 0;
    }

    private static List<Car> initCars(String inputCarNames){
        String[] names = inputCarNames.split(",");

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        return cars;
    }

    public List<Car> racingCars(){

        if(isRacingEnd()){
            throw new IllegalCallerException("이미 경기는 종료되었습니다.");
        }

        round++;

        for(Car car : cars){
            car.move(stadiumMoveOption.getValue());
        }

        return cars;
    }

    public boolean isRacingEnd() {
        return totalRound <= round;
    }

    public List<Car> getWinner() {
        final int maxPosition = getMaxCarPosition();

        return getSpecificLocationCars(maxPosition);
    }

    public int getMaxCarPosition() {
        return cars.stream()
                .mapToInt(x -> x.getPosition())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Car> getSpecificLocationCars(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }


    public int getRound() {
        return round;
    }
}
