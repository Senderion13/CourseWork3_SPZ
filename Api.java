import java.io.*;
import java.net.*;

public class Api {
    public String getResponse(String params) throws Exception {
        // URL of the API
        URL url = new URL("http://localhost:3000" + params);

        // Create a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Include any necessary headers
        connection.setRequestProperty("Content-Type", "application/json");

        // Get the response code
        int responseCode = connection.getResponseCode();

        // If the request was successful, read and print the response
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close connections
            in.close();
            connection.disconnect();

            return content.toString();
        } else {
            return "GET request failed. Response Code: " + responseCode;
        }
    }
}
