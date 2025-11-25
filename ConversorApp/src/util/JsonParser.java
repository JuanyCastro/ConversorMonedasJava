package util;

import model.ExchangeRate;
import com.google.gson.Gson;

public class JsonParser {

    private final Gson gson = new Gson();

    public ExchangeRate convertir(String json) {
        return gson.fromJson(json, ExchangeRate.class);
    }
}
