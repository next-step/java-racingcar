package lotto.stringsumcalculator.model;

public class StringFilter {

    public static String filtering(String string){
        if ("$^*(){}[]^?$.+".contains(string)) {
            string = "\\" + string;
        }

        return string;
    }
}
