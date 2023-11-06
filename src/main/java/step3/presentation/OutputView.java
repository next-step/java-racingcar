package step3.presentation;

import java.util.List;

public class OutputView {

        private final List<String> pathByRoundOfCars;

        public OutputView(List<String> pathByRoundOfCars) {
                this.pathByRoundOfCars = pathByRoundOfCars;
        }

        public void printResult() {
                pathByRoundOfCars.forEach(System.out::println);
        }
}
