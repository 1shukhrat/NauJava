import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPTask {

    public static void start() {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/get")).build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String host = response.headers().firstValue("Host").orElse("Unknown");
            System.out.println("Адрес хоста: " + host);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
