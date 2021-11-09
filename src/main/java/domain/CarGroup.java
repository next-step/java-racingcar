package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private static final String EMPTY_ERROR_MESSAGE = "error : 차 이름은 공백 을 입력할수 없습니다.";
    private static final String NULL_ERROR_MESSAGE = "error : 차 이름은 NULL 을 입력할수 없습니다.";
    private static final String CAR_COUNT_ERROR_MESSAGE = "error : 레이싱 경주는 2인 이상 가능합니다.";
    private static final int CAR_COUNT_MINIMUM = 1;
    private static final String COMMA = ",";
    private final List<Car> carGroup;

    public CarGroup(String car){
        checkNull(car);
        checkEmpty(car);
        checkCarCount(car);
        this.carGroup = Collections.unmodifiableList(carNames(car));
    }

    private List<Car> carNames(String car){
        String[] carArray = ofStringArray(car);
        return Arrays.stream(carArray)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void checkNull(String car){
        if(car == null){
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private void checkEmpty(String car){
        if(car.isEmpty()){
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    private void checkCarCount(String car){
        if(carNames(car).size() <= CAR_COUNT_MINIMUM){
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }
    }

    private String[] ofStringArray(String car){
        return car.split(COMMA);
    }

    public int size(){
        return carGroup.size();
    }

    public String findCarName(int index){
        return carGroup.get(index).getCar();
    }
}
