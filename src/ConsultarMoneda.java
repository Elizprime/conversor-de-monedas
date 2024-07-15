import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public Monedas buscarMoneda(String monedaBase, String monedaTarget) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/a519b45e35b5a17a8b95bec2/pair/" + monedaBase + "/" + monedaTarget);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            ExchangeRateResponse exchangeRateResponse = new Gson().fromJson(response.body(), ExchangeRateResponse.class);
            if ("success".equals(exchangeRateResponse.getResult())) {
                return new Monedas(monedaBase, monedaTarget, exchangeRateResponse.getConversion_rate());
            } else {
                throw new RuntimeException("No encontré la Moneda");
            }
        } catch (Exception e) {
            throw new RuntimeException("No encontré la Moneda", e);
        }
    }
}




