public class Game {
    private View view = new View();
    private Input input = new Input();
    private RandomMaker randomMaker = new RandomMaker();

    public void playGame() throws Exception {
        int countCar = input.inputCar();
        int countTry = input.inputTry();

        playRound(countCar, countTry);
    }

    private void playRound(int countCar, int countTry) {
        Car[] cars = new Car[countCar];
        for (int i = 0; i < countCar; i++) {
            cars[i] = new Car(0);
        }

        view.resultView();

        for (int i = 0; i < countTry; i++) {
            playMove(cars);
        }
    }

    private void playMove(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].decideMove(randomMaker.generateRandom());
            view.gameResultView(resultStr(cars[i]));
        }
        System.out.println("@@@@@@@@@@@");
    }

    public String resultStr(Car car) {
        String result = "";
        for (int i = 0; i < car.getPosition(); i++) {
            result += "-";
        }
        return result;
    }
}
