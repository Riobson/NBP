package pl.dashboard.nbp;

public class MainClass {
    public static void main(String[] args) {
        runApp(args);
    }

    private static void runApp(String[] args) {
        ParametersValidator parametersValidator = new ParametersValidator();
        if (parametersValidator.validateParams(args)) {
            String date = args[0];
            CurrencyService currencyService = new CurrencyService();
            String jsonString = currencyService.getCurrencyExchangeRatesForDate(date);
            if (jsonString != null) {
                CurrencyAssembler currencyAssembler = new CurrencyAssembler();
                System.out.println(currencyAssembler.currencyExchangeRatesFromStringJson(jsonString));
            }
        }
    }
}
