package step3;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {

    public String maxPostionCarName(List<CarDto> carsPosition){
        int winnerPostion = maxPosition(carsPosition);
        return carsPosition.stream()
                            .filter(f -> isWinnerPosition(f, winnerPostion))
                            .map(CarDto::getName)
                            .collect(Collectors.joining(", "));
    }

    public int maxPosition(List<CarDto> carsPosition){
        return carsPosition.stream()
                            .mapToInt(v -> v.getPosition())
                            .max()
                            .getAsInt();
    }

    private boolean isWinnerPosition(CarDto carDto, int winnerPostion){
        return carDto.getPosition() == winnerPostion;
    }


}
