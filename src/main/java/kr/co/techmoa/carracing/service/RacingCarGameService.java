package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.CarEngine;
import kr.co.techmoa.carracing.service.move.RandomMoveStrategy;
import kr.co.techmoa.carracing.ui.dto.InputDTO;
import kr.co.techmoa.carracing.ui.dto.OutputDTO;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {

    public static int[] totalCarResult ;

    public OutputDTO start(InputDTO inputDTO) {
        List<List<Car>> roundAll = createRound(createCar(inputDTO));
        List<Integer> winList = checkWin(totalCarResult);
        return new OutputDTO(roundAll, winList);
    }

    public List<Car> createCar(InputDTO inputDTO) {
        List<Car> round = new ArrayList<>();
        totalCarResult = new int[inputDTO.getCarNum()];
        String[] carNames = parseCarName(inputDTO.getCarNames());
        for(int i= 0; i< carNames.length; i++) {
            Car car = new Car(carNames[i]);
            int moveCnt = new CarEngine().operator(new RandomMoveStrategy());
            car.move(moveCnt);
            totalCarResult[i] += moveCnt;
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

    public List<Integer> checkWin(int[] totalCarResult) {
        CarWinCheckService carWinCheckService = new CarWinCheckService();
        return carWinCheckService.checkGameResult(totalCarResult);
    }

}
