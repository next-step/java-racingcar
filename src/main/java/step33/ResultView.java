package step33;

import java.util.List;

public class ResultView {

    private List<CarResponse> carResponses;

    public ResultView(List<CarResponse> carResponses) {
        this.carResponses = carResponses;
    }

    public void print() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < carResponses.size(); i++) {
            List<String> carMoves = carResponses.get(i).getCarMoves();
            printCarsMove(carMoves);
            System.out.println();
        }
    }

    public void printCarsMove(List<String> movesOfCars) {
        for (String result : movesOfCars) {
            System.out.println(result);
        }
    }

}
