package step33;

import java.util.List;

public class CarResponse {

    private List<Integer> carMoves;

    public CarResponse(List<Integer> carMoves) {
        this.carMoves = carMoves;
    }

    public static CarResponse of(List<Integer> carMoves) {
        return new CarResponse(carMoves);
    }

    public List<Integer> getCarMoves() {
        return carMoves;
    }
}
