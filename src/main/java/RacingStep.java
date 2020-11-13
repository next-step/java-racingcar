import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingStep {

    private List<Integer> carPositionList;

    public RacingStep(ArrayList<RacingCar> racingCarList) {
        carPositionList = racingCarList.stream()
                .map(racingCar -> racingCar.getPosition())
                .collect(Collectors.toList());
    }

    public List<Integer> getCarPositionList() {
        return carPositionList;
    }
}
