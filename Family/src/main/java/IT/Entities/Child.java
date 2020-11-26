package IT.Entities;

import com.eclipsesource.json.JsonObject;

import java.time.LocalTime;

/**
 * @author MJ
 */
public class Child extends Person {

    public Child(String name, int age, Gender2 gender) {
        super(name, age, gender);
    }

    public Child(JsonObject obj) {
        super(obj);
    }

    @Override
    public boolean isInSchool() {
        LocalTime now = LocalTime.now();
        if ((now.getHour() >= 8) && (now.getHour() <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isAtWork() {
        return false;
    }
}
