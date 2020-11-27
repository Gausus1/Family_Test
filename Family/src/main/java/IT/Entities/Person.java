package IT.Entities;

import com.eclipsesource.json.JsonObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author MJ
 */
public abstract class Person implements Comparable {
    private String name;
    private int age;
    private Gender gender;




    public Person(String name, int age, Gender gender) {
        this.setName(name);
        this.age = age;
        this.gender=gender;
    }

    public Person(JsonObject obj) {
        this.setName(obj.get("name").asString());
        this.setAge(obj.get("age").asInt());
    }

    public abstract boolean isAtWork();

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(Object o) {
        Person someoneElse = (Person) o;
        if (someoneElse.getAge() > this.getAge()) {
            return -1;
        } else if (someoneElse.getAge() == this.getAge()) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean isInSchool() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("| %15s | %3d | %6s | %5s | %6s |",
                this.name,
                this.age,
                this.isInSchool()?"yes":"no",
                this.isAtWork()?"yes":"no",
                this.gender.toString());

    }

    public String toJSONedString() {
        JsonObject obj = new JsonObject();
        obj.add("name", this.getName());
        obj.add("age", this.getAge());
        return obj.toString();
    }

    public Document toXMLDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("person");
        root.addElement("name")
                .addText(this.getName());
        root.addElement("age")
                .addText(this.getAge() + "");

        return document;
    }

    public String toCSVString() {
        return this.getName() + ";" + this.getAge();
    }
}
