package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PediatricianEntity extends BaseEntity{
    private static String DEFAULT_SQL= "SELECT * FROM pediatrician";
    private List<Pediatrician> findByCriteria(String sql){
        List<Pediatrician> pediatricians;
        if (getConnection() !=null){
            pediatricians = new ArrayList<>();
                try {
                    ResultSet resultSet = getConnection()
                            .createStatement()
                            .executeQuery(sql);
                    while (resultSet.next()){
                        Pediatrician pediatrician = new Pediatrician()
                                .setId(resultSet.getInt("id"))
                                .setName(resultSet.getString("first_name"))
                                .setLastname(resultSet.getString("last_name"))
                                .setPhone(resultSet.getString("phone"));
                        pediatricians.add(pediatrician);
                    }
                    return pediatricians;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        public List<Pediatrician> findAll(){
            return findByCriteria(DEFAULT_SQL);
        }

        public Pediatrician findById(int id){
        List<Pediatrician> pediatricians = findByCriteria(DEFAULT_SQL + " WHERE pediatrician_id = "+ String.valueOf(id));
        return (pediatricians != null ? pediatricians.get(0) : null);
    }

        public  Pediatrician findByName(String name){
        List<Pediatrician> pediatricians = findByCriteria(DEFAULT_SQL + " WHERE pediatrician_name = '" + name + "'");
        return (pediatricians !=null ? pediatricians.get(0) : null);
        }

        private  int updateByCriteria(String sql){
        if (getConnection() != null){
                try {
                    return  getConnection()
                            .createStatement()
                            .executeUpdate(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }
        public  boolean delete(int id){
        return  updateByCriteria("DELETE FROM pediatricians " + "WHERE pediatrician_id = " + String.valueOf(id)) >0;
        }
}
