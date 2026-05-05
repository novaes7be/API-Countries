import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CountryParser {

    public static void parse(String json) {
        JsonArray array = JsonParser.parseString(json).getAsJsonArray();

        for (int i = 0; i < array.size(); i++) {
            String country = array.get(i).getAsJsonObject().get("name").getAsJsonObject().get("common").getAsString();

            JsonObject language = array.get(i).getAsJsonObject().get("languages").getAsJsonObject();
            for (String key : language.keySet()) {
                System.out.println( country +  "----" +  language.get(key).getAsString());
            }
        }// O(n^2)

    }
}
