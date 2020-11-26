package IT.Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Gender2 {
    F,M;
    public static Gender2 getGender(String name){

        Pattern p = Pattern.compile(".*(a)$");      // z knihovny java.util.regex
        Matcher isFemale = p.matcher(name);
        if (isFemale.matches()) {
            System.out.println(Gender2.F.toString());
            return Gender2.F;

        }
        else{
            System.out.println(Gender2.M.toString());
            return Gender2.M;}

    }

}
