package study.step3;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Champion {
    private final static String ROUNDS_ILLEGAL_EXCEPTION = "최소 실행 라운드는 1회 이상입니다.";

    private final List<Round> rounds;

    public Champion(List<Round> rounds) {
        validateRounds(rounds);
        this.rounds = rounds;
    }

    private void validateRounds(List<Round> rounds) {
        if (Objects.isNull(rounds) || rounds.size() < 1){
            throw new IllegalArgumentException(ROUNDS_ILLEGAL_EXCEPTION);
        }
    }

    public List<String> getChampitions() {
        Round lastRound = rounds.get(rounds.size()-1);
        int lastMaxPosition = maxCarPostion(lastRound.getCars());

        return lastRound.getCars()
                .stream()
                .filter(car -> car.isMyCurrentPosition(lastMaxPosition))
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
    }

    public int maxCarPostion(List<Car> cars){
        return cars.stream()
                .mapToInt(Car :: getCarPosition)
                .max()
                .getAsInt();
    }
}
