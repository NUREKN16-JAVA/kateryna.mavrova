package main.java.ua.nure.kn.mavrova.usermanagment.db_2;

import java.ua.nure.kn.mavrova.usermanagment.db_2.UserDao;
import ua.nure.kn.mavrova.usermanagment.User;
import ua.nure.kn.mavrova.usermanagment.db_2.DatabaseException;
import ua.nure.kn.mavrova.usermanagment.db_2.ConnectionFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class MockUserDao implements UserDao {

    private long id = 0;

    private Map<Long, User> users = new HashMap<Long, User>();

    @Override
    public User create(User user) throws DatabaseException {
        Long currentId = new Long(++id);
        user.setId(currentId);
        users.put(currentId, user);
        return user;
    }

    @Override
    public User find(Long id) throws DatabaseException {
        return (User) users.get(id);
    }

    @Override
    public Collection<User> findAll() throws DatabaseException {
        return users.values();
    }

    @Override
    public void update(User user) throws DatabaseException {
        Long currentId = user.getId();
        users.remove(currentId);
        users.put(currentId, user);
    }

    @Override
    public void delete(User user) throws DatabaseException {
        Long currentId = user.getId();
        users.remove(currentId);
    }

    @Override
    public void setConnectionFactory(ConnectionFactory cf) {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<User> find(String firstName, String lastName) throws DatabaseException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ConnectionFactory getConnectionFactory() {
        return null;
    }

}