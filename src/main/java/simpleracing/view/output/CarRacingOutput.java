package simpleracing.view.output;

import simpleracing.domain.tools.CarRacingResult;

public class CarRacingOutput {

	public static void render(CarRacingResult result) {
		System.out.println("실행 결과");
		System.out.println(result.view());
	}
}
