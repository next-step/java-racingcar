package lotto.stringsumcalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separators {

    private final List<Separator> separators = new ArrayList<>();

    public Separators(){
        separators.add(new Separator(","));
        separators.add(new Separator(":"));
    }

    public Separators(String string){
        String pattern = "//(.*?)\\\\n";
        Matcher matcher = Pattern.compile(pattern).matcher(string);

        separators.add(new Separator(","));
        separators.add(new Separator(":"));

        while(matcher.find()){
            separators.add(new Separator(matcher.group(1)));
        }
    }

    public int getCount(){
        return separators.size();
    }

    public Separator getSeparator(int index){
        return separators.get(index);
    }


}
