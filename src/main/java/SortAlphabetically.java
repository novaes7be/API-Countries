import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortAlphabetically {
    public static JsonArray sortAlphabetically(JsonArray array, String... fields) {
        List<JsonElement> list = new ArrayList<>();
        array.forEach(list::add);

        list.sort(Comparator.comparing(e -> {
            JsonObject obj = e.getAsJsonObject();

            for (int i = 0; i < fields.length - 1; i++) {
                obj = obj.get(fields[i]).getAsJsonObject();
            }
            return obj.get(fields[fields.length - 1]).getAsString();
        }));

        JsonArray sorted = new JsonArray();
        list.forEach(sorted::add);
        return sorted;
    }
}
