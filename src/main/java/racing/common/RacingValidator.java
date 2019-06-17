package racing.common;

import spark.utils.StringUtils;

public class RacingValidator {
    public static boolean isValidCarNames(String carNames) {
        if (StringUtils.isEmpty(carNames)) {
            return false;
        }
        
        if (!isInCarCountRange(carNames.split(",").length)) {
            return false;
        } 
        
        return true;
    }
    
    public static boolean isInCarCountRange(int carCount) {
        if (RacingSettings.MIN_CAR_COUNT.getValue() <= carCount && RacingSettings.MAX_CAR_COUNT.getValue() >= carCount) {
            return true;
        }
        return false;
    }
    
    public static boolean isInTimeCountRange(int time) {
        if (RacingSettings.MIN_TIME.getValue() <= time && RacingSettings.MAX_TIME.getValue() >= time) {
            return true;
        }
        return false;
    }
}
