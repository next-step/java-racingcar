package racinggame.view;

import racinggame.dto.CarDto;
import racinggame.dto.History;

public class OutPutView {

    private static final String OUTPUT_CHAR = "-";

    public static void render(History snapShot) {
        System.out.println("실행 결과");
        for (int count = 0; count < snapShot.repeatCount(); count++) {
            renderCars(snapShot, count);
        }
    }

    private static void renderCars(History snapShot, int count) {
        for (CarDto carDto : snapShot.getSnapShot(count)) {
            System.out.println(renderHyphen(carDto.position()));
        }
        System.out.println();
    }

    private static String renderHyphen(int count) {
        return OUTPUT_CHAR.repeat(count);
    }
}
