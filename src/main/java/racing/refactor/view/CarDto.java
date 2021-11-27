package racing.refactor.view;

import java.util.List;
import java.util.Objects;

public class CarDto {

    public static class Request {

        public static class GameCreation {

            private List<String> carNames;
            private int loopCount;

            public GameCreation(List<String> carNames, int loopCount) {
                this.carNames = carNames;
                this.loopCount = loopCount;
            }

            public List<String> getCarNames() {
                return carNames;
            }

            public int getLoopCount() {
                return loopCount;
            }

            public int getCarCount() {
                return carNames.size();
            }
        }
    }

    public static class Response {

        public static class CarInformation {

            private String name;
            private int distanceDriven;

            public CarInformation(String name, int distanceDriven) {
                this.name = name;
                this.distanceDriven = distanceDriven;
            }

            public String getName() {
                return this.name;
            }

            public int getDistanceDriven() {
                return this.distanceDriven;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                CarInformation that = (CarInformation) o;
                return distanceDriven == that.distanceDriven && Objects.equals(name, that.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, distanceDriven);
            }
        }
    }
}
