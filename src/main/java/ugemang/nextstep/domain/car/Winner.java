package ugemang.nextstep.domain.car;

import ugemang.nextstep.domain.message.RacingGameMessageEnum;

import java.util.List;

public class Winner {
    private final List<Car> winners;

    public Winner(List<Car> winners) {
        validateIsExistsWinners(winners);
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }

    private void validateIsExistsWinners(List<Car> winners) {
        if(winners.size() < 1){
            throw new IllegalArgumentException(String.format(RacingGameMessageEnum.E3.getMessage(), winners.size()));
        }
    }

    public StringBuffer toStringBuffer(){
        StringBuffer sb = new StringBuffer();
        for(Car i : getWinners()){
            sb.append(i.getName());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("가 최종 우승했습니다.");
        return sb;
    }
}
