package IT.data;

import IT.Entities.Person;
import IT.Entities.PersonFactory;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.*;
import java.util.ArrayList;

/**
 * @author MJ
 */
public class Loader extends Storage {

    public static ArrayList<Person> loadPersonsFromJsons() throws IOException {
        File dir = new File(JSON_PATH);
        if (!dir.exists()) {
            return null;
        }
        int index = 0;
        ArrayList<Person> personList = new ArrayList<>();
        while (true) {
            File f = new File(JSON_PATH, index + ".txt");
            if (!f.exists()) {
                break;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            JsonObject obj = Json.parse(s).asObject();
            Person p = PersonFactory.getPerson(obj.get("name").asString(), obj.get("age").asInt());
            personList.add(p);
            br.close();
            fr.close();
            index++;
        }
        return personList;
    }

    public static ArrayList<Person> loadPersonsFromWeb() throws IOException {
        ArrayList<Person> personList = new ArrayList<>();

        Document doc = Jsoup.connect(PROJECT_URL).get();
        //System.out.println(doc.body());

        Elements rows = doc.select("tr");
        for (Element row : rows) {
            Elements tds = row.select("td");

            String id = tds.get(0).html();  // can be used in the future
            String name = tds.get(1).html();
            int age = Integer.parseInt(tds.get(2).html());
            Person p = PersonFactory.getPerson(name, age);
            personList.add(p);
        }

        return personList;
    }

    public static ArrayList<Person> loadPersonsFromCSV() throws IOException {
        File f = new File(PATH, CSV_NAME);
        if(!f.exists()){
            return null;
        }

        ArrayList<Person> personList = new ArrayList<>();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            String[] cols = s.split(";");
            if (cols.length < 2) {
                continue;   // wrong number of columns
            }

            try {
                Person p = PersonFactory.getPerson(cols[0], Integer.parseInt(cols[1].trim()));
                personList.add(p);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();   // wrong age
            }
        }
        br.close();
        fr.close();

        return personList;
    }
}
