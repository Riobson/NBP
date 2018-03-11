package pl.dashboard.nbp;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CurrencyService {
    private static final String PATH_TO_C_TABLE_NBP = "http://api.nbp.pl/api/exchangerates/tables/c/";
    private static final String PATH_JSON_FORMAT = "/?format=json";
    private static final int INCORRECTLY_FORMULTED_QUERY = 400;
    private static final int NO_DATA_FOUND = 404;

    /**
     * @param date of exchange rates
     * @return String json that contains exchange rates for all currency or null if nothing found
     */
    public String getCurrencyExchangeRatesForDate(String date) {
        Client client = Client.create();
        WebResource webResource = client
                .resource(PATH_TO_C_TABLE_NBP + date + PATH_JSON_FORMAT);
        ClientResponse response = webResource.get(ClientResponse.class);

        switch (response.getStatus()) {
            case INCORRECTLY_FORMULTED_QUERY:
                System.out.println("Error - incorrectly formulated query");
                return null;
            case NO_DATA_FOUND:
                System.out.println("Error - no data found for date " + date);
                return null;
        }
        return response.getEntity(String.class);
    }
}
