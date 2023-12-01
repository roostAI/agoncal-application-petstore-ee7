/*
1. Scenario: Pass a parameter to the function that is present in the `RequestParameterMap`.
   Expected Result: The function should return the value of the passed parameter.

2. Scenario: Pass a parameter to the function that is not present in the `RequestParameterMap`.
   Expected Result: The function should return null since the passed parameter is not present in the map.

3. Scenario: Pass a null to the method as an argument.
   Expected Result: The function should return null since map.get(null) normally returns null.

4. Scenario: Check the function return when the `FacesContext` object is not initialized.
   Expected Result: This scenario should throw a `NullPointerException` as it is trying to access a method on a null instance.

5. Scenario: Pass an empty string to the function.
   Expected Result: The function should return null. This is because an empty string would not normally be associated with a value in the parameter map.

6. Scenario: Check the behaviour with various parameter types.
   Expected Result: The function should correctly handle Strings, special characters, numbers and so on.

7. Scenario: Check the function in different Locales/environments.
   Expected Result: No impact on the result as the function doesn't rely on any locales or environmental settings.

8. Scenario: Ensure the function handles concurrent requests appropriately and returns the correct values.
   Expected Result: No impact on results or performance regardless of the number of concurrent requests.

9. Scenario: Pass a parameter that corresponds to a large value in the `RequestParameterMap`.
   Expected Result: The function should return the value without any error or truncation.

10. Scenario: Check the effect when the `ExternalContext` in `FacesContext` is changed during execution.
    Expected Result: The returned value should correspond to the state of the `ExternalContext` at the time when the method was called. Changes made afterward should have no effect on it.
*/
import org.agoncal.application.petstore.util.Loggable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ApplicationBean {

    @Inject
    private transient Logger logger;

    public String getMessage(FacesContext facesContext, String msgKey, Object... args) {
        Locale locale = facesContext.getViewRoot().getLocale();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale, classLoader);
        String msgValue = bundle.getString(msgKey);
        return MessageFormat.format(msgValue, args);
    }

    public void addInformationMessage(String message, Object... args) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, getMessage(context, message, args), null));
    }

    public void addWarningMessage(String message, Object... args) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, getMessage(context, message, args), null));
    }

    public void addErrorMessage(String message, Object... args) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, getMessage(context, message, args), null));
    }

    public String getParam(String param) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> map = context.getExternalContext().getRequestParameterMap();
        return map.get(param);
    }

    public Long getParamId(String param) {
        return Long.valueOf(getParam(param));
    }
}
