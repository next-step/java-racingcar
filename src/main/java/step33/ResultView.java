package step33;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private List<CarResponse> carResponses;

    public ResultView(List<CarResponse> carResponses) {
        this.carResponses = carResponses;
    }

    public void print() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < carResponses.size(); i++) {
            List<Integer> carMoves = carResponses.get(i).getCarMoves();
            printCarsMove(carMoves);
            System.out.println();
        }
    }

    private void printCarsMove(List<Integer> movesOfCars) {
        movesOfCars.stream()
                .map(moveOfCar -> getStringCarsMove(moveOfCar))
                .forEach(System.out::println);
    }

    private String getStringCarsMove(int index) {
        return IntStream.range(0, index)
                .mapToObj(moveCount -> "-")
                .collect(Collectors.joining());
    }

}
