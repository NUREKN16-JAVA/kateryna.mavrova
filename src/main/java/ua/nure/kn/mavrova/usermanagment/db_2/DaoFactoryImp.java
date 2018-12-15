package ua.nure.kn.mavrova.usermanagment.db_2;


public class DaoFactoryImp extends DaoFactory {
    public UserDao getUserDao(){
        UserDao result;
        try {
            Class clasz = Class.forName(properties.getProperty(USER_DAO));
            result = (UserDao) clasz.newInstance();
            result.setConnectionFactory(getConnectionFactory());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
