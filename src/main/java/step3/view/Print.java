package step3.view;

import java.util.List;

public class Print {

    public static void print(String message){
        System.out.println(message);
    }

    public static void print(List list){
        for(Object item : list){
            print(item.toString());
        }
    }

}
