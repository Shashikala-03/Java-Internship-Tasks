import java.io.*;
import java.net.*;

public class ApiClient {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.agify.io/?name=shashikala");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String result = response.toString();

            // Extract values manually (simple parsing)
            String name = result.split("\"name\":\"")[1].split("\"")[0];
            String age = result.split("\"age\":")[1].split(",")[0].replaceAll("[^0-9]", "");
            String count = result.split("\"count\":")[1].split(",")[0];

            // Structured output
            System.out.println("===== API RESPONSE =====");
            System.out.println("Name  : " + name);
            System.out.println("Age   : " + age);
            System.out.println("Count : " + count);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}