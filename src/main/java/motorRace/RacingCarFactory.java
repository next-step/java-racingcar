package motorRace;

import java.util.ArrayList;
import java.util.List;

// 경주용 차를 만드는 책임
public class RacingCarFactory {

    public RacingCars makeRacingCars(int carCnt){
        return new RacingCars(makeRacingCarList(carCnt));
    }

    private List<RacingCar> makeRacingCarList(int carCnt){
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < carCnt ; i++) {
            racingCarList.add(new RacingCar());
        }
        return racingCarList;
    }
}
