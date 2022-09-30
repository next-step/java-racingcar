package study;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String WiNNER_MESSAGE = "실행결과";
    private static final String MOVE_SIGN = "-";

    public void racingResult(List<Car> carList){
        System.out.println(RESULT_MESSAGE);
        for (Car car :carList){
            System.out.println(car.getCarName() + " : ");
            carMove(car);
            System.out.println();
        }

        System.out.println("");

    }

    public List<Winner> racingWinner(List<Car> carList) {
        int moveNumber = carList.get(0).getMoveCount();
        List<Winner> winnerList = new ArrayList<>();
        for (Car car : carList) {
            winnerList = makeWinnerList(moveNumber, car);
        }

        return winnerList;
    }

    private List<Winner> makeWinnerList(int moveNumber, Car car) {
        List<Winner> winnerList = new ArrayList<>();
        if(car.getMoveCount() > moveNumber){
            winnerList.add(new Winner(car.getCarName()));
        }
        return winnerList;
    }

    private void carMove(Car car) {
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.print(MOVE_SIGN);
        }
    }
}
