/*
1. **Test the Error Message with Valid Inputs**
   This test scenario is designed to check if the function is capable of translating and displaying a valid error message based on given arguments. 

2. **Test the Error Message with No Input**
   Will test if the function is capable of handling an error situation where no arguments are passed to it. It should ideally return a default message or log an error without crashing.

3. **Test the Error Message with Null Message**
   This scenario will check how the function behaves when sent a null message. 

4. **Test the Error Message with Different Locales**
   Check if the method can support and return appropriate translated messages in different languages based on locale.

5. **Test the Error Message with Multiple Arguments**
   - Will the function behave as expected when an array of arguments is passed to it?
   - If the number of arguments required is more or less than expected in the message?

6. **Check if the Error Message is being logged**
   Verifying that the error is not only displayed to the user but also logged for developer reference using logging mechanism.

7. **Test the Error Message with Special Characters**
   This scenario will test if the function can handle special characters and properly encode/escape them in the error message.

8. **Test the Severity of the Error Message**
    Verify if the severity of every error message added is accurately set as "Severity_Error".

9. **Test the Error Message Context**
   This dataset aims to ensure that the error message is added to the current instance of the FacesContext.

10. **Test the Error Message with Invalid Context**
    Will the function handle the situation when the FacesContext instance is null or invalid?

Note: These scenarios are black box testing scenarios and primarily used to test the behavior of the system with different types of input and circumstances. The list is not exhaustive and the specific requirements of the system may call for more specific test cases.
*/
package org.agoncal.application.petstore.view;

import org.junit.Test;
import org.agoncal.application.petstore.util.Loggable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.logging.Logger;

public class AbstractBeanTest {

    private transient Logger logger;

    @Test
    public void testGetMessage() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String msgKey = "test";
        Object[] args = new Object[]{"arg1", "arg2"};
        String result = getMessage(facesContext, msgKey, args);
        assert result != null;
    }

    @Test
    public void testAddInformationMessage() {
        String message = "test";
        Object[] args = new Object[]{"arg1", "arg2"};
        addInformationMessage(message, args);
    }

    @Test
    public void testAddWarningMessage() {
        String message = "test";
        Object[] args = new Object[]{"arg1", "arg2"};
        addWarningMessage(message, args);
    }

    @Test
    public void testAddErrorMessage() {
        String message = "test";
        Object[] args = new Object[]{"arg1", "arg2"};
        addErrorMessage(message, args);
    }

    @Test
    public void testGetParam() {
        String param = "param";
        String result = getParam(param);
        assert result != null;
    }

    @Test
    public void testGetParamId() {
        String param = "param";
        Long result = getParamId(param);
        assert result != null;
    }

    private void addErrorMessage(String message, Object... args) {
        FacesContext context = FacesContext.getCurrentInstance();
        assert context != null;
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, getMessage(context, message, args), null));
    }

    private void addWarningMessage(String message, Object... args) {
        FacesContext context = FacesContext.getCurrentInstance();
        assert context != null;
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, getMessage(context, message, args), null));
    }

    private void addInformationMessage(String message, Object... args) {
        FacesContext context = FacesContext.getCurrentInstance();
        assert context != null;
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, getMessage(context, message, args), null));
    }

    private String getMessage(FacesContext facesContext, String msgKey, Object... args) {
        Locale locale = facesContext.getViewRoot().getLocale();
        assert locale != null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale, classLoader);
        String msgValue = bundle.getString(msgKey);
        return MessageFormat.format(msgValue, args);
    }

    private String getParam(String param) {
        FacesContext context = FacesContext.getCurrentInstance();
        assert context != null;
        Map<String, String> map = context.getExternalContext().getRequestParameterMap();
        return map.get(param);
    }

    private Long getParamId(String param) {
        return Long.valueOf(getParam(param));
    }
}
