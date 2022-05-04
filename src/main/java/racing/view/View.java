package racing.view;

import racing.domain.Cars;
import racing.domain.CurPositionResult;
import racing.domain.Position;

import java.util.List;

public class View {

    private static final String CAR_STATE_BAR = "-";


    public String createCurPositionStateExp(int position){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <position; i++) {
            sb.append(CAR_STATE_BAR);
        }
        return sb.toString();
    }

    public void printRaceResult(List<CurPositionResult> curPositionResults){
        for (CurPositionResult curPositionResult : curPositionResults) {
            String exp = createCurPositionStateExp(curPositionResult.getPosition());
            System.out.println(curPositionResult.getName()+" : "+exp);
        }
        System.out.println();
    }

    public void printGameResult(Cars cars){
        List<String> nameList = cars.getWinners();
        String winners = String.join(",", nameList);
        System.out.println(winners+"가 최종 우승했습니다.");
    }

}
