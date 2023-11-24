package motorRace;

import java.util.List;

// 경주용 자동차의 일급 컬렉션
public class RacingCars {
    private List<RacingCar> racingCarList;

    public RacingCars(List<RacingCar> racingCarList){
        this.racingCarList = racingCarList;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
