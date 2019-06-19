package com.mommoo.step2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CarWinnerComputer {
    private static final int NONE_OF_WINNER_CAR_POSITION = 0;
    private final List<String> winnerCarNameList = new LinkedList<>();

    public CarWinnerComputer(List<Car> cars) {
        int maxPosition = NONE_OF_WINNER_CAR_POSITION;
        // 키 값  : 자동차 이동 포지션.
        Map<Integer, List<String>> carMapper = new HashMap<>();
        for (Car car : cars) {
            int carMovePosition = car.getPosition();
            carMapper.putIfAbsent(carMovePosition, new LinkedList<>());
            List<String> carNameList = carMapper.get(carMovePosition);

            String carName = car.getName();
            carNameList.add(carName);

            maxPosition = Math.max(maxPosition, carMovePosition);
        }

        if (maxPosition == NONE_OF_WINNER_CAR_POSITION) {
            return ;
        }

        List<String> maxPositionCarList = carMapper.get(maxPosition);
        winnerCarNameList.addAll(maxPositionCarList);
    }

    public boolean isWinnerNotExist() {
        return winnerCarNameList.size() == 0;
    }

    public List<String> getWinnerCarNameList() {
        return new LinkedList<>(winnerCarNameList);
    }
}
