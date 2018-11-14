package ua.nure.kn.mavrova.usermanagment;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class UserTest {

    private static final Long ID = 1L;
    private static final String MY_FIRST_NAME = "Kateryna";
    private static final String MY_LAST_NAME  = "Mavrova";
    private static Date myDate;
    private User user;
    private Calendar calendar;

    @Before
    public void setUp() throws Exception {
        myDate = new SimpleDateFormat("dd-MM-yyyy").parse("01-12-1998");
        user = new User(ID,MY_FIRST_NAME, MY_LAST_NAME, myDate);
        calendar = Calendar.getInstance();
    }

    @Test
    public void testAgeNow() {
        int ageExpected = 19;

        calendar.set(1999,calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));

        user.setDateOfBirth(calendar.getTime());

        int ageActual = user.getAge();

        assertEquals(ageExpected, ageActual);
    }

    @Test
    public void testAgeBirthdayOneDayAfterToday() {
        int ageExpected = 19;
        calendar.set(1998,calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH + 1));
        user.setDateOfBirth(calendar.getTime());
        int ageActual = user.getAge();
        assertEquals(ageExpected, ageActual);
    }


    @Test
    public void ageTestSameMonthBefore(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(1998, Calendar.OCTOBER, 15);
        User user = new User(ID, MY_FIRST_NAME, MY_LAST_NAME, calendar.getTime());
        assertEquals(20, user.getAge());
    }

    @Test
    public void simpleAgeTestAfter(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.APRIL, 11);
        User user = new User(ID, MY_FIRST_NAME, MY_LAST_NAME, calendar.getTime());
        assertEquals(19, user.getAge());
    }


    @Test
    public void testNewbornAge() {
        int ageExpected = 0;

        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));

        user.setDateOfBirth(calendar.getTime());

        int ageActual = user.getAge();
        assertEquals(ageExpected, ageActual);
    }


    @Test
    public void testFullName() {
        String resultExpected = MY_LAST_NAME + ", " + MY_FIRST_NAME;
        assertEquals(resultExpected,user.getFullName());
    }
}