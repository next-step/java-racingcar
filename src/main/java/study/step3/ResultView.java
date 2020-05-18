package study.step3;

import java.util.List;

public class ResultView {
    private static final String UNDER_BAR_SYMBOL ="_";
<<<<<<< HEAD
    private static final int INIT_ZERO = 0;

    private List<Round> rounds;

    public ResultView(List<Round> rounds) {
        this.rounds = rounds;
=======
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
>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
    }

    public void print() {
        roundToString();
    }

    private void roundToString() {
<<<<<<< HEAD
        for (Round round : rounds){
            carToString(round.getCars());
=======
        for (int i = INIT_INDEX; i < rounds; i++){
            carStatusToString(i);
>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
            System.out.println();
        }
    }

<<<<<<< HEAD
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
=======
    private void carStatusToString(int i) {
        for (Car car : results){
            System.out.println(car.carNameToString()+convertToUnderBarSymbol(car.pointInTimeCarPostion(i)));
        }
    }

>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844
}
