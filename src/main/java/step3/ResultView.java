package step3;

public class ResultView {

    public void printResult() {
        System.out.println(ViewConstant.RESULT);
    }

    public void printCars(Cars cars) {
        cars.getCars()
            .forEach(this::printTrack);
        System.out.println();
    }

    private void printTrack(Car car) {
        StringBuffer track = new StringBuffer();
        for (int position = 0; position < car.getPosition(); ++position) {
            track.append(ViewConstant.TRACK);
        }
        System.out.println(track);
    }
}
