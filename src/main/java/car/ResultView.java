package car;

import java.util.List;

public class ResultView {

    public void resultView(Car car){
        System.out.print(car.getName()+" : ");
        LinePrint(car.getPosition());
    }

    private void LinePrint(int size){
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void winnerView(String winnerName){
        System.out.println(winnerName+"가 우승하였습니다.");
    }

    public String winnerPrint(RacingResult racingResult){
        String winnerName = "";
        for(Car car : racingResult.getWinnerCars()){
            winnerName += addComma(winnerName)+car.getName();
        }
        return winnerName;
    }

    public String addComma(String winnerName){
        if(!winnerName.equals("")){
            return ",";
        }
        return winnerName;
    }
}
