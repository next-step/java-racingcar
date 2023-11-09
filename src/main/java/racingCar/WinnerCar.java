package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WinnerCar {
    public static void main(String[] args) {
        Map<String, Object> inputMap = InputView.inputNamedCar();
        String carNames = inputMap.get("carNames").toString();
        int tyrNum = (int) inputMap.get("tryNum");

        NamedCars namedCars = new NamedCars(carNames);
        RacingCar.movingResultNamedCar(namedCars, tyrNum);
        WinnerCar.returnWinner(namedCars);
    }

    public static List<String> returnWinner(NamedCars namedCars){
        int maxForward = namedCars.getMaxForward();

        List<String> winners = new ArrayList<>();

        for(Car car : namedCars.getCarList()){
            if(car.getForwardCnt() == maxForward) winners.add(car.getCarName());
        }

        ResultView.printWinner(winners);

        return winners;
    }
}
