package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.CarName;
import kr.co.techmoa.carracing.service.move.RandomMoveStrategyImpl;
import kr.co.techmoa.carracing.ui.dto.InputDTO;
import kr.co.techmoa.carracing.ui.dto.OutputDTO;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {

    private int[] totalCarResult ;
    private InputDTO inputDTO;

    public RacingCarGameService(InputDTO inputDTO) {
        this.totalCarResult = new int[inputDTO.getCarNum()];
        this.inputDTO = inputDTO;
    }

    public OutputDTO start() {
        List<List<Car>> roundAll = createRound();
        return new OutputDTO(roundAll, checkWin(totalCarResult));
    }

    public List<List<Car>> createRound() {
        List<List<Car>> roundAll = new ArrayList<>();

        for (int i = 0; i < inputDTO.getTryNumber(); i++) {
            List<Car> round = createCar();
            roundAll.add(round);
        }
        return roundAll;
    }

    private String[] parseCarName(String carNames) {
        return carNames.split(",");
    }

    public List<Car> createCar() {
        String[] carNames = parseCarName(inputDTO.getCarNames());
        List<Car> round = new ArrayList<>();
        for (int j = 0; j < inputDTO.getCarNum(); j++) {
            Car car = new Car(new CarName(carNames[j]));
            boolean isMove = car.moveOperator(new RandomMoveStrategyImpl());
            car.move(createMove(j, isMove));
            round.add(car);
        }
        return round;
    }

    public boolean createMove(int position , boolean isMove) {
        if(isMove)
            this.totalCarResult[position] += 1;
        return isMove;
    }


    public List<Integer> checkWin(int[] totalCarResult) {
        return new CarWinCheckService().checkGameResult(totalCarResult);
    }

    public int[] getTotalCarResult() {
        return totalCarResult;
    }

}
