package study;

public class StringCalculator {

    private static final String DEFAULT_DELIMETER = "[,:-]";

    public int calculate(String data){
        int result = 0;

        if(checkStrNull(data))
            return 0;

        try{
            String delimeter = getDelimeter(data);
            String finData = getNumberData(data);
            String[] texts = doSplit(finData, delimeter);
            isNumbers(texts);
            result = sumNumber(texts);

        }catch(RuntimeException re) {
            re.printStackTrace();
        }

        return result;
    }

    public boolean checkStrNull(String data){
        if(data == null)
            return true;

        if(data.equals(""))
            return true;

        return false;
    }

    public String getDelimeter(String data) {
        if(getDataSplit(data) == null)
            return DEFAULT_DELIMETER;

        return getDataSplit(data)[0];
    }

    public String getNumberData(String data){
        if(getDataSplit(data) == null)
            return data;

        return getDataSplit(data)[1];
    }

    public String[] getDataSplit(String data){ //아 근데 getter를 쓰지말라는게 set,get으로 시작하는걸 쓰지 말라는건가?
        String[] splitData = data.split("//");
        if(splitData.length == 1)
            return null;

        return splitData[1].split("\n");
    }

    public String[] doSplit(String data, String delimeter) {
        String[] nums = data.split(delimeter);
        return nums;
    }

    public boolean isNumbers(String[] data) throws RuntimeException {
        try {
            for(String s : data){
                int num = Integer.parseInt(s);
                checkMinusNum(num);
            }

            return true;

        }catch(NumberFormatException e){
            throw new RuntimeException();
        }
    }

    public void checkMinusNum(int num) throws RuntimeException{
        if(num < 0)
            throw new RuntimeException();
    }

    public int sumNumber(String[] data){
        int result = 0;

        for(String s : data)
            result += Integer.parseInt(s);

        return result;
    }
}
