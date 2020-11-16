package racingcar.step3.domain;

/**
 * Created : 2020-11-02 오전 8:22.
 * Developer : Seo.
 */
public class Race {
    private final Cars cars;
    private final Record record;

    public Race(String carsName) {
        this.record = new Record();
        this.cars = new Cars(record, carsName);
    }

    public Cars run(int turns) {
        for (int i = 0; i < turns; i++) {
            cars.roll();
        }
        return this.cars;
    }

}
