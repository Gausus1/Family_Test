package IT.Entities;

import IT.LogStream;

/**
 * @author MJ
 */
public class PersonFactory {



    public static Person getPerson(String name, int age) {
        return getPerson(name, age, 0);
    }

    public static Person getPerson(String name, int age, int wage) {
        Gender gender=null;
        LogStream log = LogStream.getInstance();
        if (age > 150) {
            System.err.println("Too old for this software");
        }

        if (age < 18) {
            log.info("Person "+ name + " with age "+ age);
            return new Child(name, age, Gender.getGender(name));
        } else if (age < 65) {
            log.info("Person "+ name + " with age "+ age);
            return new Adult(name, age, Gender.getGender(name), wage);
        } else {
            log.info("Person "+ name + " with age "+ age);
            return new Senior(name, age, Gender.getGender(name), wage);
        }
    }

}
