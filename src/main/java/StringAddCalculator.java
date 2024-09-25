public class StringAddCalculator {
    public int splitAndSum(String text){
        String[] numbers= splitNum(text);
        int sum =0;
        for(String number:numbers){
            sum+=Integer.parseInt(number);
        }
        return sum;
    }

    public String[] splitNum(String text){
        if(text==null){
            return new String[]{"0"} ;
        }
        if(text.isEmpty()){
            return new String[]{"0"};
        }

        return text.split(",|:");
    }
}
