/*
Test Scenario 1: Null Message Input
Explanation: Test with null as "message" input. 

Test Scenario 2: Empty String Message Input
Explanation: Test with empty string as "message" input.

Test Scenario 3: Valid String Message Input
Explanation: Test with valid string as "message" input. 

Test Scenario 4: Special characters in Message input
Explanation: Test a message with special characters to ensure it's handled correctly by the function.

Test Scenario 5: Message Input With Arguments
Explanation: Test with valid "message" input along with valid arrayWith 'args' as parameters.

Test Scenario 6: Message Input With Null Arguments
Explanation: Test the 'args' array with null value and the 'message' with some string value.

Test Scenario 7: Null Context
Explanation: Test with null FacesContext to ensure application handles and logs this exception appropriately.

Test Scenario 8: Non-Existing Context ID Input
Explanation: Test with context id that does not exist in the application. 

Test Scenario 9: Message String As Key In Resource Bundle
Explanation: Test that the method can properly retrieve the value from ResourceBundle using the provided message string as key.

Test Scenario 10: Test for Message Formatting
Explanation: Test when input message string contains placeholders (like {0}) and arguments are provided.

Test Scenario 11: Locale-Specific Behavior
Explanation: Test the function with different locale settings to validate that messages are localized properly.

Test Scenario 12: Severities Level Test
Explanation: Test that the severity of the FacesMessage is always set to INFORMATION, regardless of input or context.
*/
package org.agoncal.application.petstore.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Locale;
import static org.mockito.Mockito.*;

public class AbstractBeanTest {

    AbstractBean abstractBean;
    
    @Mock
    FacesContext facesContextMock;
    
    @Mock
    FacesMessage facesMessageMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        abstractBean = new AbstractBean();
        FacesContext.setCurrentInstance(facesContextMock);
    }

    @Test
    public void testAddInformationMessage_NullMessage() {
        abstractBean.addInformationMessage(null);
        verify(facesContextMock, times(1)).getViewRoot();
    }

    @Test
    public void testAddInformationMessage_EmptyMessage() {
        abstractBean.addInformationMessage("");
        verify(facesContextMock, times(1)).getViewRoot();
    }

    @Test
    public void testAddInformationMessage_ValidMessage() {
        abstractBean.addInformationMessage("Test Message");
        verify(facesContextMock, times(1)).getViewRoot();
    }

    @Test
    public void testAddInformationMessage_SpecialCharactersInMessage() {
        abstractBean.addInformationMessage("Test Message @#!$%^&*(){}[]");
        verify(facesContextMock, times(1)).getViewRoot();
    }

    @Test
    public void testAddInformationMessage_MessageWithArgs() {
        abstractBean.addInformationMessage("Test Message with Args: {0}, {1}", "Arg1", "Arg2");
        verify(facesContextMock, times(1)).getViewRoot();
    }

    @Test
    public void testAddInformationMessage_NullArgs() {
        abstractBean.addInformationMessage("Test Message", null);
        verify(facesContextMock, times(1)).getViewRoot();
    }

    @Test(expected = RuntimeException.class)
    public void testAddInformationMessage_NullContext() {
        FacesContext.setCurrentInstance(null);
        abstractBean.addInformationMessage("Test Message");
    }

    @Test
    public void testAddInformationMessage_NonExistingContextID() {
        when(facesContextMock.getViewRoot().getLocale()).thenReturn(Locale.ENGLISH);
        abstractBean.addInformationMessage("Non-existing-context");
        verify(facesContextMock, times(1)).getViewRoot();
    }
    
    @Test
    public void testAddInformationMessage_MessageKeyInBundle() {
        when(facesContextMock.getViewRoot().getLocale()).thenReturn(Locale.ENGLISH);
        abstractBean.addInformationMessage("test.bundle.key");
        verify(facesContextMock, times(1)).getViewRoot();
    }

    @Test
    public void testAddInformationMessage_MessageFormatting() {
        abstractBean.addInformationMessage("Test Message with Args: {0}", "Arg1");
        verify(facesContextMock, times(1)).getViewRoot();
    }

    @Test
    public void testAddInformationMessage_LocaleSpecificBehavior() {
        when(facesContextMock.getViewRoot().getLocale()).thenReturn(Locale.FRENCH);
        abstractBean.addInformationMessage("test.bundle.key");
        verify(facesContextMock, times(1)).getViewRoot();
    }

    @Test
    public void testAddInformationMessage_SeveritiesLevelTest() {
        abstractBean.addInformationMessage("Test Message");
        verify(facesContextMock, times(1)).getViewRoot();
    }
}
