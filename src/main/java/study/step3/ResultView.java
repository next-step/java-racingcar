package study.step3;

import java.util.List;

public class ResultView {
    private static final String UNDER_BAR_SYMBOL ="_";
    private static final int INIT_INDEX = 0;

    private final int rounds;
    private List<Car> results;

    public ResultView(List<Car> result) {
        this.results = result;
        this.rounds = result.get(INIT_INDEX).rounds();
    }

    private String convertToUnderBarSymbol(Integer pointInTimeCarPostion) {
        StringBuffer stringBuffer = new StringBuffer(UNDER_BAR_SYMBOL);
        for (int i = INIT_INDEX; i < pointInTimeCarPostion; i++){
            stringBuffer.append(UNDER_BAR_SYMBOL);
        }
        return stringBuffer.toString();
    }

    public void print() {
        roundToString();
    }

    private void roundToString() {
        for (int i = INIT_INDEX; i < rounds; i++){
            carStatusToString(i);
            System.out.println();
        }
    }

    private void carStatusToString(int i) {
        for (Car car : results){
            System.out.println(car.carNameToString()+convertToUnderBarSymbol(car.pointInTimeCarPostion(i)));
        }
    }

}
