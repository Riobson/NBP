package pl.dashboard.nbp;

import org.json.JSONArray;
import org.json.JSONObject;

public class CurrencyAssembler {
    private static final int FIRST_ELEMENT = 0;

    /**
     * @param jsonString contains exchange rates for all currency
     * @return String that contains exchange rates for EUR, CHF, USD, GBP
     */
    public StringBuilder currencyExchangeRatesFromStringJson(String jsonString) {
        final JSONObject json = new JSONArray(jsonString).getJSONObject(FIRST_ELEMENT);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Data: ").append(json.getString("effectiveDate")).append(Constants.NEW_LINE);
        stringBuilder.append("Waluta = kupno; sprzedaż").append(Constants.NEW_LINE);
        final JSONArray jsonArray = json.getJSONArray("rates");
        final int jsonArrayLenght = jsonArray.length();
        for (int i = 0; i < jsonArrayLenght; i++) {
            JSONObject rate = jsonArray.getJSONObject(i);
            String code = rate.getString("code");
            switch (code) {
                case "EUR":
                case "CHF":
                case "USD":
                case "GBP":
                    stringBuilder.append(code).append(Constants.SPACE).append(rate.get("bid")).append(Constants.SEMICOLON).append(Constants.SPACE)
                            .append(rate.get("ask")).append(Constants.NEW_LINE);
            }
        }
        return stringBuilder;
    }
}
