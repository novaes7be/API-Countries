import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CountryParser {

    public static void parseLanguage(String json) {
        JsonArray array = JsonParser.parseString(json).getAsJsonArray();

        for (int i = 0; i < array.size(); i++) {     // O(n^2)
           String country = array.get(i).getAsJsonObject().get("name").getAsJsonObject().get("common").getAsString();
           JsonObject language = array.get(i).getAsJsonObject().get("languages").getAsJsonObject();

            for (String key : language.keySet()) {
                System.out.println( country +  "----" +  language.get(key).getAsString());
            }
        }
    }

    public static void parseAll(String json) {
        JsonArray array = JsonParser.parseString(json).getAsJsonArray();

        for (int i = 0; i < array.size(); i++) {     // O(n^2)
            String country = array.get(i).getAsJsonObject().get("name").getAsJsonObject().get("common").getAsString();

            JsonObject currencies = array.get(i).getAsJsonObject().get("currencies").getAsJsonObject();
            if (currencies.keySet().isEmpty()) continue;
            String code = currencies.keySet().iterator().next();
            String currencyName = currencies.get(code).getAsJsonObject().get("name").getAsString();

            System.out.println("    " + country + "   -   " + currencyName + "   -   " +   code);
        }
    }

    public static void parseName(String jsonName){
        JsonArray nameArray = JsonParser.parseString(jsonName).getAsJsonArray();

        for (int i = 0; i < nameArray.size(); i ++) {
            String name = nameArray.get(i).getAsJsonObject().get("name").getAsJsonObject().get("common").getAsString();
            System.out.println( "     "+ name);

        }
    }
    public static void parseRegion(String jsonRegion) {
        JsonArray regionArray = JsonParser.parseString(jsonRegion).getAsJsonArray();

        for (int i = 0; i < regionArray.size(); i++){
            String country = regionArray.get(i).getAsJsonObject().get("name").getAsJsonObject().get("common").getAsString();
            String region = regionArray.get(i).getAsJsonObject().get("region").getAsString();
            System.out.println("        " +   country  + " -- "+ region );

        }
    }

}/*
parseName(String json) — só extrai e printa o nome
parseRegion(String json) — printa nome de cada país
parseLanguage(String json) — printa país----idioma pra cada idioma
parseAll(String json) — printa nome, capital e moeda*/