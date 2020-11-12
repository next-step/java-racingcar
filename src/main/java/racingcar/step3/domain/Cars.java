package racingcar.step3.domain;

import racingcar.step3.common.Consts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-12 오전 10:20
 * Developer : Seo
 */
public class Cars {
    private final Record record;
    private final List<Car> carList;
    private String winner;

    public Cars(String carsName, Record record) {
        this.record = record;
        this.carList = new ArrayList<>();
        String[] arrCarsName = carsName.split(",");
        for (String carName : arrCarsName) {
            carList.add(new Car(carName));
        }
        this.winner = Consts.WINNER_INIT;
    }

    public List<Car> getCars() {
        return this.carList;
    }

    public void setWinner(Car car) {
        if (isMyRecord(car) || breakTheRecord(car)) {
            winner = car.getName();
        }
        if (isTheTieRecord(car)) {
            winner = winner + ", " + car.getName();
        }
    }

    public String getWinner() {
        return this.winner;
    }

    private boolean isMyRecord(Car car) {
        if (winner.equals("")
                && record.getBestRecord() == car.getDistance()) {
            return true;
        }
        return false;
    }

    private boolean breakTheRecord(Car car) {
        return Integer.compare(record.getBestRecord(), car.getDistance()) == -1;
    }

    private boolean isTheTieRecord(Car car) {
        if (!winner.equals("")
                && !winner.contains(car.getName())
                && record.getBestRecord() == car.getDistance()) {
            return true;
        }
        return false;
    }

}
