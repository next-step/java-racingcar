package step3.presentation;

import java.util.ArrayList;

public class OutputView {

        private final ArrayList<String> pathByRoundOfCars;

        public OutputView(ArrayList pathByRoundOfCars) {
                this.pathByRoundOfCars = pathByRoundOfCars;
        }

        public void printResult() {
                pathByRoundOfCars.forEach(pathByRound -> {
                        System.out.println(pathByRound);
                });
        }
}
