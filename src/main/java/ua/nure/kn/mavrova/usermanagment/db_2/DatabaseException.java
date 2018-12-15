package ua.nure.kn.mavrova.usermanagment.db_2;


public class DatabaseException extends Exception {
    public DatabaseException(Throwable  cause) {
        super(cause);
    }

    public DatabaseException() {
        super();
    }

    public DatabaseException(String message) {
        super(message);
    }
}
