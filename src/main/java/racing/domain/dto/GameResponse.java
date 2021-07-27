package racing.domain.dto;

import racing.domain.Location;
import racing.domain.car.Car;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GameResponse {
    private HashMap<Car, Location> gameResult;

    public GameResponse(HashMap<Car, Location> gameResult) {
        this.gameResult = gameResult;
    }
}
