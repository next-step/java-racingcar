public class StrCalcCondition {

    public boolean checkCondition(String strForCalc) {
        return isBlank(strForCalc) && isFirstEndNum(strForCalc);
    }

    private boolean isBlank(String strForCalc) {
        if (strForCalc == null || strForCalc.trim().equals("")) {
            throw new IllegalArgumentException("this is empty string");
        }
        return true;
    }

    private boolean isFirstEndNum(String strForCalc) {
        String startStr = strForCalc.substring(0, 1);
        String endStr = strForCalc.substring(strForCalc.length() - 1);

        if (!isNumber(startStr) || !isNumber(endStr)) {
            throw new IllegalArgumentException("start and end char must be number to calculate");
        }
        return true;
    }

    private boolean isNumber(String strForCalc) {
        return (strForCalc.charAt(0) - '0' < 10 && strForCalc.charAt(0) - '0' >= 0);
    }
}
