package racingcar.service;

import racingcar.vo.Car;

import java.util.ArrayList;
import java.util.List;

public class SystemService {
    private MoveService moveService = new MoveService();

    public List<Car> carInfo = new ArrayList<>();

    public void splitString(String input) {
        String[] result = input.split(",");
        for (int i = 0; i < result.length; i++) {
            Car carVO = new Car(result[i],0);

            carInfo.add(carVO);
        }
    }

    public int moveCar(int locationInfo) {
        String check = moveService.isMove();
        int movedLocation = Operation.result(check, locationInfo);
        return movedLocation;
    }

    public List<String> checkWinner(int cycle) {
        List<String> winnerName = new ArrayList<>();
        for (int i = 0; i < carInfo.size(); i++) {
            winnerName.add(selectWinnerName(i, cycle));
        }
        return winnerName;
    }

    public String selectWinnerName(int i, int cycle) {
        String winnerName = null;
        if (carInfo.get(i).getLocationInfo() == cycle) {
            winnerName = carInfo.get(i).getName();
        }
        return winnerName;
    }
}
