import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ClientHttp {

    static final String BASE_URL = "https://restcountries.com/v3.1";


    public String get(String fullUrl) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .timeout(Duration.ofMillis(5000)).uri(URI.create(fullUrl))
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse
                            .BodyHandlers
                            .ofString());

            int statusCode = response.statusCode();

            if (statusCode == 200) {
                return response.body();
            } else {
                return null;
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public  String getByName(){   return get(BASE_URL + "/all?fields=name");
    }
    public  String getByRegion(String region){   return get(BASE_URL + "/region/" + region)   ;
    }
    public   String getAll(){   return get(BASE_URL + "/all?fields=name,capital,currencies,languages")  ;
    }
    public   String getByLanguage(String language){   return get(BASE_URL + "/lang/" + language );
    }

}
