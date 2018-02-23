package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM countries";
    private List<Pediatrician> findByCriteria(String sql, PediatricianEntity regionsEntity) {
        List<Pediatrician> countries = new ArrayList<>();
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while(resultSet.next()) {
                    Pediatrician country = new Pediatrician(
                    );
                    countries.add(country);
                }
                return countries;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


}

