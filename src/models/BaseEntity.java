package models;

import java.sql.Connection;

public class BaseEntity {
    private Connection connection;
    Connection getConnection(){
        return connection;
    }
    private void setConnection(Connection connection){
        this.connection = connection;
    }
}
