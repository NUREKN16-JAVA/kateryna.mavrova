package java.ua.nure.kn.mavrova.usermanagment.web;


import ua.nure.kn.mavrova.usermanagment.User;

import java.text.DateFormat;
import java.util.Date;

public class AddServletTest extends MockServletTestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
        createServlet(AddServlet.class);
    }
    public void testAdd() {
        Date date = new Date();
        User newUser = new User("Kate", "Mavrova", date);
        User user = new User(new Long(1000), "Kate", "Mavrova", date);
        getMockUserDao().expectAndReturn("create", newUser, user);

        addRequestParameter("firstName", "Kate");
        addRequestParameter("lastName", "Mavrova");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
    }

    public void testAddEmptyFirstName() {
        Date date = new Date();
        addRequestParameter("lastName", "Mavrova");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddEmptyLastName() {
        Date date = new Date();
        addRequestParameter("firstName", "Kate");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddEmptyDate() {
        Date date = new Date();
        addRequestParameter("firstName", "Kate");
        addRequestParameter("lastName", "Mavrova");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddInvalidDate() {
        Date date = new Date();
        addRequestParameter("firstName", "Kate");
        addRequestParameter("lastName", "Mavrova");
        addRequestParameter("date", "pppppp");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

}
