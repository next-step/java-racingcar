package racing.domain;

import racing.domain.dto.ResultDto;

public class RacingGame {

    private Cars cars;
    private int count;

    public RacingGame(Cars cars, int tryCont) {
        this.cars = cars;
        this.count = tryCont;
    }

    public void start(){
        for (int round =0; round < count; round++){
            race();
        }
    }

    private void race(){
        cars.race();
    }

    public ResultDto resultDto() {
        return new ResultDto(cars.getCars(), count);
    }
}
