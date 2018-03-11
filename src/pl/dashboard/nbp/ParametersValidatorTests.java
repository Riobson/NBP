package pl.dashboard.nbp;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ParametersValidatorTests {

    @Test
    public void GivenMoreThenOneParameter_WhenTryToRunApp_Then_ValidationReturnFalse() {
        String[] args = new String[2];
        args[0] = "First param";
        args[0] = "Second para,";
        ParametersValidator parametersValidator = new ParametersValidator();
        assertThat(parametersValidator.validateParams(args), is(false));
    }

    @Test
    public void GivenNoParameter_WhenTryToRunApp_Then_ValidationReturnFalse() {
        String[] args = new String[2];
        ParametersValidator parametersValidator = new ParametersValidator();
        assertThat(parametersValidator.validateParams(args), is(false));
    }

    @Test
    public void GivenOneIncorrectParameter_WhenTryToRunApp_Then_ValidationReturnFalse() {
        String[] args = new String[1];
        args[0] = "invalid parameter";
        ParametersValidator parametersValidator = new ParametersValidator();
        assertThat(parametersValidator.validateParams(args), is(false));
    }

    @Test
    public void GivenOneCorrectDateParameter_WhenTryToRunApp_Then_ValidationReturnTrue() {
        String date = "2018-01-01";
        String[] args = new String[1];
        args[0] = date;
        ParametersValidator parametersValidator = new ParametersValidator();
        assertThat(parametersValidator.validateParams(args), is(true));
    }

    @Test
    public void GivenOneParameterWithNonExistingDate_WhenTryToRunApp_Then_ValidationReturnFalse() {
        String date = "2018-01-32";
        String[] args = new String[1];
        args[0] = date;
        ParametersValidator parametersValidator = new ParametersValidator();
        assertThat(parametersValidator.validateParams(args), is(false));
    }
}
