package racing.util;

import java.util.List;

public class StringSplitter {

    public static List<String> getNameList(String nameListString){
        return List.of(nameListString.split(","));
    }
}
