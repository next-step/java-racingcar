package racingcargame;


public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = new Cars();
        cars.addCars(inputView.inputCarCount());

        Racing racing = new Racing(cars.getCars(), inputView.inputTryCount());
        for (int i = 0; i < racing.getTryCount(); i++) {
            racing.race();
        }

        System.out.println("최종 우승자: " + racing.getWinner());
    }
}
