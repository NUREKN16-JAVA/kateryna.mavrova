package ua.nure.kn.mavrova.usermanagment.db_2;

import java.sql.Connection;


public interface ConnectionFactory {
    Connection createConnection() throws DatabaseException;
}
