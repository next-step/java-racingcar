package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Stadium {
    private final CarCollection carCollection;
    private final int totalRound;
    private final StadiumMoveOption stadiumMoveOption;

    private int round;

    // 이름리스트를 초기값으로 받는 버전
    public Stadium(CarCollection carCollection, int totalRound){
        this(carCollection, totalRound, new RandomStadiumMoveOptionImpl());
    }

    // 차 리스트를 초기로 받는 버전
    public Stadium(CarCollection carCollection, int totalRound, StadiumMoveOption stadiumMoveOption){
        this.carCollection = carCollection;
        this.totalRound = totalRound;
        this.stadiumMoveOption = new RandomStadiumMoveOptionImpl();

        this.round = 0;
    }



    public List<Car> racingCars(){

        if(isRacingEnd()){
            throw new IllegalCallerException("이미 경기는 종료되었습니다.");
        }

        round++;

        for(Car car : carCollection.getCars()){
            car.move(stadiumMoveOption.getValue());
        }

        return carCollection.getCars();
    }

    public boolean isRacingEnd() {
        return totalRound <= round;
    }

    public List<Car> getWinner() {
        final int maxPosition = getMaxCarPosition();

        return getSpecificLocationCars(maxPosition);
    }

    public int getMaxCarPosition() {
        return carCollection.getCars().stream()
                .mapToInt(x -> x.getPosition())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Car> getSpecificLocationCars(int position) {
        return carCollection.getCars().stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }


    public int getRound() {
        return round;
    }
}
