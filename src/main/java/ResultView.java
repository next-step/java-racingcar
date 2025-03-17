public class ResultView {
    public void present(String result) {
        System.out.println(result);
    }

    public void presentCars(int[] carPositions) {
        for (int carPosition : carPositions) {
            System.out.println("-".repeat(carPosition));
        }
    }
}
