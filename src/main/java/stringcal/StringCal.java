package stringcal;

public class StringCal {

    CalculateFunc calFunc = new CalculateFunc();

    public int calculateString(String str){

        String[] strList = seperate(str);
        int result = toInt(strList[0]);

        for(int i = 0; i < strList.length - 2; i += 2){

            result = calFunc.calculate(result, strList[i + 1].charAt(0), toInt(strList[i + 2]));

        }
        return result;
    }

    public int toInt(String str){

        return Integer.parseInt(str);
    }

    public String[] seperate(String str){

        return str.split(" ");
    }

}