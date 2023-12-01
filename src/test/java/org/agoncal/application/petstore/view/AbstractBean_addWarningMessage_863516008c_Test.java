/*
Test Scenario 1: Adding a warning message
- Given: A call to addWarningMessage function with a valid message string and arguments. 
- Expected: The method should use the FacesContext instance to add a new message with the provided string and arguments, resulting in a warning message's addition in the FacesContext.

Test Scenario 2: Handling of Null message
- Given: A call to addWarningMessage function with null as a message string and valid arguments.
- Expected: The function should handle the null message, without causing null pointer exceptions. It should also result in no addition of a message in the FacesContext.

Test Scenario 3: Adding a warning message with null arguments
- Given: A call to addWarningMessage function with a valid message string and null arguments.
- Expected: The function should handle null arguments without causing any exceptions, the message should be added in the FacesContext without any formatted arguments.

Test Scenario 4: Adding a warning message without any arguments
- Given: A call to addWarningMessage function with a valid message string and without any arguments.
- Expected: The function should add a message to the FacesContext without any arguments. 

Test Scenario 5: Calling addWarningMessage when FacesContext is not initialised
- Given: A call to addWarningMessage function when the FacesContext is not initialised.
- Expected: The function should handle gracefully, possibly without causing null pointer exceptions or it should initialize the FacesContext before adding the message. 

Test Scenario 6: Adding a warning message with special characters or escape sequences
- Given: A call to addWarningMessage with a message string containing special characters or escape sequences and valid arguments.
- Expected: The function should correctly interpret the special characters or escape sequences and add the resultant message to the FacesContext. 

Test Scenario 7: Adding a warning message in a different Locale
- Given: A call to addWarningMessage with a message string and arguments that are specific to a different Locale.
- Expected: The function should interpret the message and arguments correctly according to the provided Locale, and the resultant message should be added to the FacesContext.
*/
package org.agoncal.application.petstore.view;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;

import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import org.junit.Before;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class AbstractBeanTest {
    private AbstractBean abstractBean;
    private FacesContext facesContext;
    private FacesMessage facesMessage;

    @Before
    public void setUp() {
        abstractBean = new AbstractBean();
        facesContext = mock(FacesContext.class);
        facesMessage = mock(FacesMessage.class);
        when(facesContext.getViewRoot().getLocale()).thenReturn(Locale.getDefault());
        when(facesContext.getMessage()).thenReturn(facesMessage);
        FacesContext.setCurrentInstance(facesContext);
    }

    @Test
    public void shouldHandleAddInformationMessage() {
        String message = "This is an information message.";
        abstractBean.addInformationMessage(message, "arg");
        verify(facesContext).addMessage(null, facesMessage);
    }

    @Test
    public void shouldVerifyingAddWarningMessage() {
        String warningMessage = "This is a warning message.";
        abstractBean.addWarningMessage(warningMessage, "arg");
        verify(facesContext).addMessage(null, facesMessage);
    }

    @Test
    public void shouldHandleAddErrorMessage() {
        String errorMessage = "This is an error message.";
        abstractBean.addErrorMessage(errorMessage, "arg");
        verify(facesContext).addMessage(null, facesMessage);
    }

    @Test
    public void shouldGetParamFromContext() {
        String param = "param";
        abstractBean.getParam(param);
        verify(facesContext.getExternalContext().getRequestParameterMap()).get(param);
    }

    @Test
    public void shouldGetParamIdFromContext() {
        String param = "paramId";
        abstractBean.getParamId(param);
        verify(Long.class, Long.valueOf(abstractBean.getParam(param)));
    }
}
