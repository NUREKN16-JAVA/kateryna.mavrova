package ua.nure.kn.mavrova.usermanagment.db_2;

import java.sql.Connection;

/**
 * Created by Константин on 07-Nov-16.
 */
public interface ConnectionFactory {
    Connection createConnection() throws DatabaseException;
}
