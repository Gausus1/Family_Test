package IT.Entities;

import com.eclipsesource.json.JsonObject;

/**
 * @author MJ
 */
public class Senior extends Person {

    private int retirement;

    public Senior(String name, int age,Gender2 gender, int retirement) {
        super(name, age, gender);
        this.retirement = retirement;
    }

    public Senior(JsonObject obj) {
        super(obj);
        this.retirement = 0;
    }

    @Override
    public boolean isAtWork() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " retirement: " + retirement;
    }
}
