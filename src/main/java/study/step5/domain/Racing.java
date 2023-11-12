package study.step5.domain;

public class Racing {

    private final NumberGenerator numberGenerator;

    public Racing(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void moveCars(Cars cars) {
        cars.getCars().forEach(car -> car.move(numberGenerator.generate()));
    }

}
