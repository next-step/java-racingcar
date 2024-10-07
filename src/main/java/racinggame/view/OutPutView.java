package racinggame.view;

import racinggame.domain.Car.CarDto;
import racinggame.dto.SnapShotDto;

public class OutPutView {

    private static final String HYPHEN = "-";

    public static void render(SnapShotDto snapShot) {
        System.out.println("실행 결과");
        for (int count = 0; count < snapShot.repeatCount(); count++) {
            renderCars(snapShot, count);
        }
    }

    private static void renderCars(SnapShotDto snapShot, int count) {
        for (CarDto carDto : snapShot.getSnapShot(count)) {
            System.out.println(renderHyphen(carDto.position()));
        }
        System.out.println();
    }

    private static String renderHyphen(int count) {
        return HYPHEN.repeat(count);
    }
}
