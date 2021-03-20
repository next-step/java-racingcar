package step4.domain.racing;

import step4.domain.car.position.Position;
import step4.domain.ipnut.InputNames;
import step4.domain.ipnut.InputRound;
import step4.dto.RequestDto;
import step4.dto.ResponseDto;
import step4.startegy.Move;

import java.util.Objects;

public final class RacingCarGame {

    private final Cars cars;
    private final Round round;

    public RacingCarGame(RequestDto requestDto){
        this(requestDto.inputNames(), requestDto.inputRound());
    }

    public RacingCarGame(InputNames inputNames, InputRound inputRound) {
        this(new Cars(inputNames), new Round(inputRound));
    }

    public RacingCarGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public final void move(Move move){
        cars.move(move);
    }

    public final boolean hasNext() {
        return round.hasNext();
    }

    public final void nextRound() {
        round.nextRound();
    }

    public final ResponseDto responseDto() {
        return new ResponseDto(cars);
    }


    private final Position maxPosition(){
        return cars.maxPosition();
    }

    public final Winners winners() {
        return new Winners(cars.winners(maxPosition()));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarGame that = (RacingCarGame) o;
        return Objects.equals(cars, that.cars) && Objects.equals(round, that.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, round);
    }

}
