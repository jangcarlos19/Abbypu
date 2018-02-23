package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PediatricianEntity extends BaseEntity{
    private static String DEFAULT_SQL= "SELECT * FROM abbyp.pediatrician";
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
                                .setId(resultSet.getInt("pediatrician_id"))
                                .setName(resultSet.getString("pediatrician_name"))
                                .setLastname(resultSet.getString("pediatrician_lastname"))
                                .setAge(resultSet.getInt("pediatrician_age"));
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

    private int getMaxId() {
        String sql = "SELECT MAX(pediatrician_id) AS max_id FROM" +
                " pediatricians";
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ?
                        resultSet.getInt("max_id")
                        : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }

    public Pediatrician create(String name, String lastname, int age) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO pediatrician(pediatrician_id, pediatrician_name) VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", '" +
                        name + "')";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    Pediatrician pediatrician = new Pediatrician(getMaxId(), name, lastname, age);
                    //eroor
                    return pediatrician;
                }
            }
        }
        return null;
    }
    public boolean update(Pediatrician region) {
        if(findByName(region.getName()) != null) return false;
        return updateByCriteria(
                "UPDATE regions SET region_name = '" +
                        region.getName() + "'" +
                        " WHERE region_id = " +
                        String.valueOf(region.getId())) > 0;
    }
}
