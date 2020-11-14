import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingStep {

    public static class RacingCarNameAndPosition {
        private String name;
        private int position;

        public RacingCarNameAndPosition(String name, int position) {
            this.name = name;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }
    }

    private List<RacingCarNameAndPosition> carNameAndPositions;

    public RacingStep(ArrayList<RacingCar> racingCarList) {
        this.carNameAndPositions = racingCarList.stream()
                .map(racingCar -> new RacingCarNameAndPosition(racingCar.getName(), racingCar.getPosition()))
                .collect(Collectors.toList());
    }


    public List<RacingCarNameAndPosition> getCarNameAndPositionList() {
        return carNameAndPositions;
    }

}
