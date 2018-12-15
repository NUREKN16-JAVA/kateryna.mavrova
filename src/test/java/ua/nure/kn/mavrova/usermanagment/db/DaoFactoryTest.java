package ua.nure.kn.mavrova.usermanagment.db;

import junit.framework.TestCase;
import org.junit.Test;
import ua.nure.kn.mavrova.usermanagment.db_2.DaoFactory;
import ua.nure.kn.mavrova.usermanagment.db_2.UserDao;

import static org.junit.Assert.*;


public class DaoFactoryTest extends TestCase {
    @Test
    public void testGetUserDao() throws Exception {
        try {
            DaoFactory daoFactory =  DaoFactory.getInstance();
            assertNotEquals("DaoFactory instance is null", daoFactory);
            UserDao userDao = daoFactory.getUserDao();
            assertNotEquals("UserDao instance is null", userDao);
        } catch (Exception e) {
            fail(e.toString());
        }
    }

}