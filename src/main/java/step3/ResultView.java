package step3;

import java.util.List;

public class ResultView {
	
	private static final String RACING_POSITION_INDICATOR = "-";

    public static void resultRacing(List<Car> racingCars) {
    	for(int i = 0; i < racingCars.size(); i++) {
    		System.out.println(createIndicator(racingCars.get(i)));
    	}
    }
    
    private static String createIndicator(Car car) {
    	StringBuilder builder = new StringBuilder();
    	for (int i = 0; i < car.getPosition(); i++) {
    	    builder.append(RACING_POSITION_INDICATOR);
    	}
    	String result = builder.toString();
    	return result;
    }

}
