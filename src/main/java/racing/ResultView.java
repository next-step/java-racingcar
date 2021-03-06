package racing;

public class ResultView {

    public void printRacingState(Racing racing) {
        racing.getCarList()
              .forEach(car -> System.out.println(car.getTrack()));

        System.out.println();
    }

}
