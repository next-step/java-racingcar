package step3.controller;

import step3.domain.Car;
import step3.service.GameService;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private GameService gameService;
    private List<Car> cars;

    private GameController() {
        this.gameService = GameService.newInstance();
        this.cars = new ArrayList<>();
    }

    public static GameController newInstance() {
        return new GameController();
    }
}
