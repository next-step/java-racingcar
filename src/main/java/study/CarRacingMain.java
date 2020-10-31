package study;


import java.util.*;

public class CarRacingMain {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        CarRacing carRacing = new CarRacing(ConsoleInputRacingInfoProvider.newInstanceWithCLI(), resultView);
        carRacing.start();
        resultView.report();
    }

    private static class ConsoleInputRacingInfoProvider implements RacingInfoProvider {

        static RacingInfoProvider newInstanceWithCLI() {
            int cars = requestInput("자동차 대수는 몇 대 인가요?");
            int steps = requestInput("시도할 회수는 몇 회 인가요?");

            Set<Car> startsGridCars = new HashSet<>();
            for (int i = 0; i < cars; i++) {
                startsGridCars.add(new RealCar());
            }
            return new ConsoleInputRacingInfoProvider(steps, startsGridCars);
        }

        private static int requestInput(String message) {
            Optional<Integer> input = Optional.empty();
            while (!input.isPresent()) {
                input = requestInputInternal(message);
            }
            return input.get();
        }

        private static Optional<Integer> requestInputInternal(String message) {
            try {
                System.out.println(message);
                return Optional.of(new Scanner(System.in).nextInt());
            } catch (InputMismatchException e) {
                System.err.println("숫자만 입력 가능합니다.");
            }
            return Optional.empty();
        }

        private final int steps;
        private final Set<Car> cars;

        public ConsoleInputRacingInfoProvider(int steps, Set<Car> cars) {
            this.steps = steps;
            this.cars = cars;
        }

        @Override
        public Set<Car> getCars() {
            return cars;
        }

        @Override
        public int countSteps() {
            return steps;
        }
    }
}
