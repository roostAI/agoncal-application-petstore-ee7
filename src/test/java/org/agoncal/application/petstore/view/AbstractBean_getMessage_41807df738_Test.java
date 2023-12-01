/*
1. Scenario: Test when FacesContext, msgKey, and no additional argument are given:
- Description: Pass a valid FacesContext object, a valid string as msgKey, and no additional arguments. Ensure that MessageFormat.format method formats the given message string with no arguments correctly and the function returns the expected result.

2. Scenario: Test when FacesContext, msgKey, and a single additional argument are given:
- Description: Pass a valid FacesContext object, a valid string as msgKey, and a single argument. The function should format the message string using the provided argument according to the locale set in the FacesContext and return the correctly formatted string.

3. Scenario: Test when FacesContext, msgKey, and multiple additional arguments are given:
- Description: Pass a valid FacesContext object, a valid string as msgKey, and multiple arguments. The function should replace placeholders in the message string with the provided arguments in order, formatted according to the locale, and return the correctly formatted string.

4. Scenario: Test when msgKey is not found in the resource bundle:
- Description: Pass valid inputs but with a msgKey that does not exist in the resource bundle. The application should handle this gracefully and not throw an exception.

5. Scenario: Test when FacesContext is null:
- Description: Pass null as the FacesContext, a valid string as msgKey, and any number of arguments. The application should throw a NullPointerException, as per Java's standard behavior when trying to access a method on a null object.

6. Scenario: Test when Locale is null:
- Description: Set the Locale in FacesContext to null. The application should use the default Locale to format the string.

7. Scenario: Test when msgKey is null:
- Description: Pass a null msgKey. The application should throw a NullPointerException as per the behavior of the ResourceBundle.getString method when passed a null key.

8. Scenario: Test when the classLoader is null:
- Description: Test when the Thread's context ClassLoader is null. According to Java's ResourceBundle documentation, a null ClassLoader should cause the ResourceBundle.getBundle method to use the system ClassLoader instead.

9. Scenario: Test when args contains null:
- Description: Test when one or more elements of the args array are null. According to the MessageFormat.format documentation, null arguments should be formatted as the string "null".
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

@Loggable
public class MessagesHelper {

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
