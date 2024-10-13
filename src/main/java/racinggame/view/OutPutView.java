package racinggame.view;

import racinggame.dto.CarDto;
import racinggame.dto.History;
import racinggame.dto.Result;

public class OutPutView {

    private static final String OUTPUT_CHAR = "-";

    public static void render(Result result) {
        System.out.println("실행 결과");
        for (int count = 0; count < result.repeatCount(); count++) {
            renderCars(result, count);
        }
        System.out.println(String.format("%s가 최종 우승했습니다.",String.join(",",result.getWinner())));
    }

    private static void renderCars(Result result, int count) {
        for (CarDto carDto : result.getSnapShot(count)) {
            System.out.println(String.format("%s : %s",carDto.name(),renderHyphen(carDto.position())));
        }
        System.out.println();
    }

    private static String renderHyphen(int count) {
        return OUTPUT_CHAR.repeat(count);
    }
}
