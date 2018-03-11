package pl.dashboard.nbp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParametersValidator {

    /**
     * @param args array of parameters
     * @return true if given parameter is valid date, else return false
     */
    public boolean validateParams(String[] args) {
        if (args.length != 1) {
            System.out.println("Incorrect parameters number - add one date parameter with format: yyyy-MM-dd");
            return false;
        }
        if (args.length == 1) {
            return isValidDate(args[0]);
        }
        return true;
    }

    /**
     * @param date to validate
     * @return true if data has format yyyy-MM-dd and exists, in other cases return false
     */
    private boolean isValidDate(String date) {
        if (date == null || !date.matches("\\d{4}-[01]\\d-[0-3]\\d")) {
            System.out.println("Incorrect date format " + date + " - correct format is: yyyy-MM-dd");
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(date);
            return true;
        } catch (ParseException ex) {
            System.out.println("Given date not exists " + date + " - enter correct date in given format: yyyy-MM-dd");
            return false;
        }
    }
}
