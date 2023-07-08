package racingcar.usecase.request;

import racingcar.domain.move.Moveable;

import java.util.List;

public class RacingGamePlayRequest {

    private final List<CarRequest> carRequests;

    public RacingGamePlayRequest(List<CarRequest> carRequests) {
        this.carRequests = carRequests;
    }

    public List<CarRequest> getCarRequests() {
        return carRequests;
    }

    public static class CarRequest {

        private final String name;
        private final Moveable moveable;

        public CarRequest(String name, Moveable moveable) {
            this.name = name;
            this.moveable = moveable;
        }

        public String getName() {
            return name;
        }

        public Moveable getMoveable() {
            return moveable;
        }
    }

}
