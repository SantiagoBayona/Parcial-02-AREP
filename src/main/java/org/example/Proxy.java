package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static spark.Spark.*;

public class Proxy {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String[] SERVERS = new String[]{"http://ec2-3-85-96-149.compute-1.amazonaws.com:4567", "http://ec2-23-23-42-52.compute-1.amazonaws.com:4567"};

    private static int currentServer = 0;

    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        get("proxy", (req,res) -> {
            return getURL(req.queryParams("value"));
        });
    }

    public static String getURL(String value) throws IOException {
        int server = currentServer;
        currentServer = (currentServer + 1) % 2;
        return getResponse(SERVERS[server] + "/lucasseq?value=" + value);
    }

    public static String getResponse(String url) throws IOException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return response.toString();
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }

} 