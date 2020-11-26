package IT.data;

import IT.Entities.Person;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.ArrayList;

/**
 * @author MJ
 */
public class Reporter extends Storage {

    public static void savePersonReport(ArrayList<Person> personList) throws IOException {
        OutputStream out = getReportFileOutputStream();
        personReportToStream(out, personList);
        out.close();
    }

    public static void printPersonReport(ArrayList<Person> personList) throws IOException {
        personReportToStream(System.out, personList);

    }

    public static void savePersonsIntoJson(ArrayList<Person> personList) throws IOException {
        File dir = new File(JSON_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        int index = 0;
        for (Person p : personList) {
            File f = new File(JSON_PATH, index + ".txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f);
            fw.write(p.toJSONedString());
            fw.close();

            index++;
        }
    }

    public static void savePersonsIntoXMLs(ArrayList<Person> personList) throws IOException {
        File dir = new File(XML_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        int index = 0;
        for (Person p : personList) {
            File f = new File(XML_PATH, (index++) + ".xml");
            if (!f.exists()) {
                f.createNewFile();
            }

            OutputFormat format = OutputFormat.createPrettyPrint();
            FileWriter fileWriter = new FileWriter(f);
            XMLWriter writer = new XMLWriter(fileWriter, format);
            writer.write(p.toXMLDocument());
            writer.close();
            fileWriter.close();
        }
    }

    public static void savePersonsIntoCSV(ArrayList<Person> personList) throws IOException {
        File f = new File(PATH, CSV_NAME);
        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        if (!f.exists()) {
            f.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for (Person p : personList) {
            bw.write(p.toCSVString() + System.getProperty("line.separator"));
        }
        bw.close();
        fileWriter.close();
    }

    private static void personReportToStream(OutputStream os, ArrayList<Person> personList) throws IOException {
        os.write(String.format("| %15s | %3s | %6s | %5s | %3s |\n", "Name", "Age", "School", "Work", "Gender").getBytes());
        os.write("---------------------------------------------------\n".getBytes());
        for (Person p : personList) {
            os.write((p.toString() + "\n").getBytes());
        }
    }

    private static OutputStream getReportFileOutputStream() throws IOException {
        File f = new File(PATH, "report.txt");
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        if (!f.exists()) {
            f.createNewFile();
        }
        OutputStream out = new FileOutputStream(f);
        return out;
    }

}
