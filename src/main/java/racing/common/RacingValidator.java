package racing.common;

import spark.utils.StringUtils;

public class RacingValidator {
    private final static int MAX_CAR_COUNT = 10;
    private final static int MAX_TIME = 50;
    private final static int MIN_CAR_COUNT = 1;
    private final static int MIN_TIME = 1;
    
    public static boolean isValidCarNames(String carNames) {
        if (StringUtils.isEmpty(carNames)) {
            return false;
        }
        String[] carNamesArr = carNames.split(RacingSettings.CAR_NAME_SEPARATOR.getStr());
        if (!isInCarCountRange(carNamesArr.length)) {
            return false;
        } 
        
        return true;
    }
    
    private static boolean isInCarCountRange(int carCount) {
        return MIN_CAR_COUNT <= carCount && MAX_CAR_COUNT >= carCount;
    }
    
    public static boolean isInTimeRange(int time) {
        return MIN_TIME <= time && MAX_TIME >= time;
    }
}
