package IT.Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Gender {
    F,M;
    public static Gender getGender(String name){

        Pattern p = Pattern.compile(".*(a)$");      // z knihovny java.util.regex
        Matcher isFemale = p.matcher(name);
        if (isFemale.matches()) {
            //System.out.println(Gender.F.toString());
            return Gender.F;

        }
        else{
            //System.out.println(Gender.M.toString());
            return Gender.M;}

    }

}
