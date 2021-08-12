package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.service.move.RandomMoveStrategy;
import kr.co.techmoa.carracing.ui.dto.InputDTO;
import kr.co.techmoa.carracing.ui.dto.OutputDTO;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {

    public OutputDTO start(InputDTO inputDTO) {
        List<List<Car>> roundAll = createRound(createCar(inputDTO));
        List<Car> finalCarResult = roundAll.get(roundAll.size());
        List<Car> winList = checkWin(finalCarResult);
        return new OutputDTO(roundAll, winList);
    }

    public List<Car> createCar(InputDTO inputDTO) {
        List<Car> round = new ArrayList<>();
        String[] carNames = parseCarName(inputDTO.getCarNames());
        for(String carName : carNames) {
            Car car = new Car(carName);
            car.move(new RandomMoveStrategy());
            round.add(car);
        }
        return round;
    }

    private String[] parseCarName(String carNames) {
        return carNames.split(",");
    }

    public List<List<Car>> createRound(List<Car> round) {
        List<List<Car>> roundAll = new ArrayList<>();
        roundAll.add(round);
        return roundAll;
    }

    public List<Car> checkWin(List<Car> cars) {
        CarWinCheckService carWinCheckService = new CarWinCheckService();
        return carWinCheckService.checkGameResult(cars);
    }

}
