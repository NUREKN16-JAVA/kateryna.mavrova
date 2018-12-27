package java.ua.nure.kn.mavrova.usermanagment.db_2;


import ua.nure.kn.mavrova.usermanagment.User;
import ua.nure.kn.mavrova.usermanagment.db_2.DatabaseException;
import ua.nure.kn.mavrova.usermanagment.db_2.ConnectionFactory;
import java.util.Collection;

public interface  UserDao {

    User create(User user) throws ua.nure.kn.mavrova.usermanagment.db_2.DatabaseException;

    void update(User user) throws DatabaseException;

    void delete(User user) throws DatabaseException;

    User find(Long id) throws DatabaseException;

    Collection findAll() throws DatabaseException;

    Collection find(String firstName, String lastName) throws DatabaseException;

    public ConnectionFactory getConnectionFactory();

    public void setConnectionFactory(ConnectionFactory connectionFactory);
}
