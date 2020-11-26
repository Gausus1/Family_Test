package IT.Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author MJ
 */
public class PersonFactory {

    /*
    public static Gender getGender(String name){
        Gender gender=null;
        Pattern p = Pattern.compile(".*(a)$");      // z knihovny java.util.regex
        Matcher isFemale = p.matcher(name);
        if (isFemale.matches()) {
            System.out.println(gender.F.toString());
            //String.format(gender.F.toString());
            return gender.F;

        }
        else{
            System.out.println(gender.M.toString());
            //String.format(gender.M.toString());}
            return gender.M;}

    }
    
     */

    public static Person getPerson(String name, int age) {
        return getPerson(name, age, 0);
    }

    public static Person getPerson(String name, int age, int wage) {
        Gender2 gender=null;
        if (age > 150) {
            System.err.println("Too old for this software");
        }
        //funkcni s fci
        /*
        if (age < 18) {
            return new Child(name, age,getGender(name));
        } else if (age < 65) {
            return new Adult(name, age,getGender(name));
        } else {
            return new Senior(name, age,getGender(name), wage);
        }

         */
        if (age < 18) {
            return new Child(name, age,Gender2.getGender(name));
        } else if (age < 65) {
            return new Adult(name, age, Gender2.getGender(name), wage);
        } else {
            return new Senior(name, age,Gender2.getGender(name), wage);
        }
    }
    /*
    public Gender getGender(String name){
        Gender gender=null;
        Pattern p = Pattern.compile(".*(a)$");      // z knihovny java.util.regex
        Matcher isFemale = p.matcher(name);
        if (isFemale.matches()) {
            System.out.println(gender.F.toString());
            //String.format(gender.F.toString());
            return gender.F;

        }
        else{
            System.out.println(gender.M.toString());
            //String.format(gender.M.toString());}
            return gender.M;}
        */

}
