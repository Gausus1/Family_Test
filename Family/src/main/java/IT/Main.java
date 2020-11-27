package IT;

import IT.Entities.Person;
import IT.Entities.PersonFactory;
import IT.data.Loader;
import IT.data.Reporter;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        LogStream log = LogStream.getInstance();
        log.info("Program started");
        //PersonFactory.getPerson("Martin", 26);

        //Gender gender=null;
        //System.out.println(gender.DETECT());
        /*
        Pattern p = Pattern.compile(".*(a)$");      // z knihovny java.util.regex
        Matcher isFemale = p.matcher("Martina");
        if (isFemale.matches()) {
            System.out.println(gender.F.toString());
            //String.format(gender.F.toString());

        }
        else{
            System.out.println(gender.M.toString());
            String.format(gender.M.toString());}
        */


        try {
            //ArrayList<Person> family = getSampleFamily();
            //ArrayList<Person> family = Loader.loadPersonsFromJsons();
            ArrayList<Person> family = Loader.loadPersonsFromWeb();
            //ArrayList<Person> family = Loader.loadPersonsFromCSV();

            Collections.sort(family);


            Reporter.printPersonReport(family);
            /*
            Reporter.savePersonReport(family);
            Reporter.savePersonsIntoJson(family);
            Reporter.savePersonsIntoCSV(family);
            Reporter.savePersonsIntoXMLs(family);
            */

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.info("Program finished");
    }

    public static ArrayList<Person> getSampleFamily() {
        ArrayList<Person> family = new ArrayList<>();

        family.add(PersonFactory.getPerson("Pepa", 10));
        family.add(PersonFactory.getPerson("Honzík", 7));

        family.add(PersonFactory.getPerson("Martin", 26));
        family.add(PersonFactory.getPerson("Martina", 27));
        family.add(PersonFactory.getPerson("Petr", 620));
        // family.add(new Adult("Petra", 60)); // pořád to jde i takto

        family.add(PersonFactory.getPerson("Anna", 85, 1000));
        family.add(PersonFactory.getPerson("Jirka", 83, 1200));

        return family;
    }
}
