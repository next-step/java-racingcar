package step3.study.domain;

public class ResponseRacingDTO {
    private Cars cars;

    public ResponseRacingDTO(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return cars;
    }
}
