package IT.Entities;

import com.eclipsesource.json.JsonObject;


import java.time.LocalTime;

/**
 * @author MJ
 */
public class Adult extends Person {

    private int wage;

    public Adult(String name, int age, Gender2 gender, int wage) {
        super(name, age, gender);
        this.wage=wage;
    }

    public Adult(JsonObject obj) {
        super(obj);
    }

    @Override
    public boolean isAtWork() {
        LocalTime now = LocalTime.now();
        if ((now.getHour() >= 15) && (now.getHour() <= 23)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " wage: " + wage;
    }


}
