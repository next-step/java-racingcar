package racingcar.domain.dto;

import racingcar.domain.request.Amount;
import racingcar.domain.request.Round;

public class RacingCarRequestDto {

    private Amount amount;
    private Round round;

    public static RacingCarRequestDto of(Amount amount, Round round){
        return new RacingCarRequestDto(amount, round);
    }

    private RacingCarRequestDto(Amount amount, Round round) {
        this.amount = amount;
        this.round = round;
    }

    public int getAmountValue() {
        return amount.getValue();
    }
    public int getRoundValue() {
        return round.getValue();
    }

}
