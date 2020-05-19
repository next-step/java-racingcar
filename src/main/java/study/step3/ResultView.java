package study.step3;

import java.util.List;

public class ResultView {
    private static final String UNDER_BAR_SYMBOL ="_";
    private static final int INIT_ZERO = 0;

    private List<Round> rounds;

    public ResultView(List<Round> rounds) {
        this.rounds = rounds;
    }

    public void print() {
        roundToString();
    }

    private void roundToString() {
        for (Round round : rounds){
            carToString(round.getCars());
            System.out.println();
        }
    }

    private void carToString(List<Car> cars) {
        for (Car car: cars){
            System.out.println(convertToUnderBarSymbol(car.getCarPosition()));
        }
    }

   private String convertToUnderBarSymbol(int pointInTimeCarPostion) {
        StringBuffer stringBuffer = new StringBuffer(UNDER_BAR_SYMBOL);
        for (int i = INIT_ZERO; i < pointInTimeCarPostion; i++){
            stringBuffer.append(UNDER_BAR_SYMBOL);
        }
        return stringBuffer.toString();
    }
}
