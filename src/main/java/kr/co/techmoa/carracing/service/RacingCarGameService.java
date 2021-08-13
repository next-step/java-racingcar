package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.CarEngine;
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
            Car car = new Car(carNames[j]);
            car.move(createMove(j));
            round.add(car);
        }
        return round;
    }

    public int createMove(int position) {
        int moveCnt = new CarEngine().moveOperator(new RandomMoveStrategyImpl());
        totalSumResult(position, moveCnt);
        return moveCnt;
    }

    public void totalSumResult(int position, int moveCnt){
        this.totalCarResult[position] += moveCnt;
    }

    public List<Integer> checkWin(int[] totalCarResult) {
        return new CarWinCheckService().checkGameResult(totalCarResult);
    }

    public int[] getTotalCarResult() {
        return totalCarResult;
    }

}
