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
                                .setName(resultSet.getString("name"))
                                .setLastname(resultSet.getString("lastname"))
                                .setCountry(resultSet.getString("country"))
                                .setPhone(resultSet.getInt("phone"))
                                .setEmail(resultSet.getString("email"));
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
        List<Pediatrician> pediatricians = findByCriteria(DEFAULT_SQL + " WHERE id = "+ String.valueOf(id));
        return (pediatricians != null ? pediatricians.get(0) : null);
    }

        public  Pediatrician findByName(String name){
        List<Pediatrician> pediatricians = findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
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
        return  updateByCriteria("DELETE FROM pediatricians " + "WHERE id = " + String.valueOf(id)) >0;
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

    public Pediatrician create(String name, String lastname, String country, int phone, String email) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO pediatrician(id, name, lastname, country, phone, email) VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", '" +
                        name + "')";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    Pediatrician pediatrician = new Pediatrician(getMaxId(), name, lastname, country, phone, email);
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
                "UPDATE pediatrician SET name = '" +
                        region.getName() + "'" +
                        " WHERE id = " +
                        String.valueOf(region.getId())) > 0;
    }
}
