package org.example;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class SparkWebServer {

    private static String list = "";

    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        get("lucasseq", (req,res) -> {
            int num = Integer.parseInt(req.queryParams("value"));
            lucas(num);
            return "{\n" +
                    "\n" +
                    " \"operation\": \"Secuencia de Lucas\",\n" +
                    "\n" +
                    " \"input\": " + num + ",\n" +
                    "\n" +
                    " \"output\": \"" + list + "\"\n" +
                    "\n" +
                    "}";
        });
    }

    private static String lucas(int value){
        String res;
        if(value == 0){
            res = "2";
        }else if(value == 1){
            res = "1";
        }else{
            res = String.valueOf(Integer.parseInt(lucas(value - 1)) + Integer.parseInt(lucas(value - 2)));
        }
        if(!list.contains(res)){
            list += res + ", ";
        }
        return res;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}