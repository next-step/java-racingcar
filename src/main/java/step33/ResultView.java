package step33;

import java.util.List;

public class ResultView {

    private List<CarResponse> carResponses;

    public ResultView(List<CarResponse> carResponses) {
        this.carResponses = carResponses;
    }

    public void print() {
        System.out.println("\n실행 결과");
        for (CarResponse carResponse : carResponses) {
            printCarsMove(carResponse);
            System.out.println();
        }
    }

    private void printCarsMove(CarResponse carResponse) {
        for (String result : carResponse.getResult()) {
            System.out.println(result);
        }
    }

}
