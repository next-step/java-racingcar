package step3;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    static void racingResult(List<CarDto> carsPosition) {
        int carNumber = carsPosition.size();
        for (int i = 0; i < carNumber; i++) {
            CarDto carDto = carsPosition.get(i);
            String carName = carDto.getName();
            int position = carDto.getPosition();
            carResult(carName, position);
        }
        System.out.println();
    }

    private static void carResult(String carName, int carMoveStatusNumber) {
        StringBuffer carMoveBuffer = new StringBuffer();
        carMoveBuffer.append(carName + " : ");
        while (carMoveStatusNumber > 0) {
            carMoveBuffer.append("-");
            carMoveStatusNumber--;
        }
        System.out.println(carMoveBuffer);
    }

    public static void racingWinnerResult(List<CarDto> carsPosition){
        int winnerPostion = maxPostion(carsPosition);
        String winners = carsPosition.stream()
                                        .filter(f -> isWinnerPosition(f, winnerPostion))
                                        .map(CarDto::getName)
                                        .collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승 했습니다.");
    }

    private static int maxPostion(List<CarDto> carsPosition){
        return carsPosition.stream()
                            .mapToInt(v -> v.getPosition())
                            .max()
                            .getAsInt();
    }

    private static boolean isWinnerPosition(CarDto carDto, int winnerPostion){
        return carDto.getPosition() == winnerPostion;
    }

}
