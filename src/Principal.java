import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual criptomoeda deseja ver a cotação?");
        var cripto = sc.nextLine();

        String endereco = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=" + cripto + "&x_cg_api_key=CG-DRKvCQGYsLQM1wZzf1vWNuBj";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
