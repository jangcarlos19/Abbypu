package models;

import java.sql.Connection;

public class BaseEntity {
    private Connection connection;
    public Connection getConnection(){
        return connection;
    }
    void setConnection(Connection connection){
        this.connection = connection;
    }
}