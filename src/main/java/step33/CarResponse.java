package step33;

import java.util.List;

public class CarResponse {

    private List<String> carMoves;

    public CarResponse(List<String> carMoves) {
        this.carMoves = carMoves;
    }

    public static CarResponse of(List<String> carMoves) {
        return new CarResponse(carMoves);
    }

    public List<String> getCarMoves() {
        return carMoves;
    }
}
