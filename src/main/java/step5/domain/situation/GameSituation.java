package step5.domain.situation;

import step5.domain.car.CarStrategy;
import step5.message.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameSituation {

    private final List<List<CarStrategy>> raceSituation = new ArrayList<>();

    public void addCarStrategy(List<CarStrategy> carStrategy) {
        raceSituation.add(copyCarStrategy(carStrategy));
    }

    public List<List<CarStrategy>> getRaceSituation() {
        return raceSituation;
    }

    //레이싱 재시작하는지를 체크한다.
    public void checkRestart() {
        if (!this.raceSituation.isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.GAME_ALREADY_START.message());
    }

    //시작을 했는지 안했는지 체크한다.
    public void checkStart() {
        if (this.raceSituation.isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.GAME_NOT_START.message());
    }

    //CarStrategy 객체를 새로운주소로 copy 한다.
    private List<CarStrategy> copyCarStrategy(List<CarStrategy> cars) {
        return cars.stream()
                .map(CarStrategy::copy)
                .collect(Collectors.toList());
    }

}
