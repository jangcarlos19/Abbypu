package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM pediatricians";
    private List<Question> findByCriteria(String sql, PediatricianEntity pediatricianEntity){
        List<Pediatrician> pediatricians = new ArrayList<>();
        if (getConnection() != null) {
                try {
                    ResultSet resultSet = getConnection()
                            .createStatement()
                            .executeQuery(sql);
                    while (resultSet.next()) {
                        Pediatrician pediatrician = new Pediatrician(
                                resultSet.getString("id"),
                                resultSet.getString("name"),
                                resultSet.getString("lastname"),
                                resultSet.getInt("score"),
                                pediatricianEntity
                                        .findById(resultSet
                                                .getInt("id"))
                        );
                        pediatricians.add(pediatrician);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
         }
        return null;
    }

    public List<Question> findAll (PediatricianEntity pediatricianEntity) {
        return findByCriteria(DEFAULT_SQL, pediatricianEntity);
    }
}

