package models;

import com.oracle.wls.shaded.org.apache.xalan.lib.sql.ConnectionPoolManager;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AbbypService {
    private Connection connection;
    private PediatricianEntity pediatricianEntity;
    private QuestionEntity questionEntity;

    private Connection getConnection() {
        if (connection == null) {
                try {
                    connection = ((DataSource) InitialContext
                        .doLookup("jdbc/MySQLDataSourcAbbyp"))
                            .getConnection();
                } catch (NamingException | SQLException e) {
                    e.printStackTrace();
                }
        }
        return  connection;
    }
    public void setConnection(Connection connection) {
    this.connection = connection;
    }

    protected  PediatricianEntity getPediatricianEntity(){
        if (getConnection() != null) {
            if (pediatricianEntity == null) {
                pediatricianEntity = new PediatricianEntity();
                pediatricianEntity.setConnection(getConnection());
            }
        }
        return pediatricianEntity;
    }

    protected QuestionEntity getQuestionEntity(){
        if (getConnection() != null) {
            if (questionEntity == null) {
                questionEntity = new QuestionEntity();
                questionEntity.setConnection(getConnection());
            }
        }
        return  questionEntity;
    }

    public List<Pediatrician> findAllPediatricians(){
        return getPediatricianEntity() != null ?
                getPediatricianEntity().findAll() : null;
    }

    public List<Question> findAllQuestions(){
            return (getQuestionEntity() != null &&
            getPediatricianEntity() != null) ?
            getQuestionEntity().findAll(getPediatricianEntity()) : null;
    }

    public  Pediatrician findPediatricianById(int id) {
        return getPediatricianEntity() != null ?
                getPediatricianEntity().findById(id) : null;
    }

    public Pediatrician findPediatricianByName (String name) {
        return getPediatricianEntity() != null ?
                getPediatricianEntity().findByName(name) : null;
    }

    public  Pediatrician createPediatrician (String name, String lastname, String country, int phone, String email) {
        return getPediatricianEntity() != null ?
                getPediatricianEntity().create(name, lastname, country, phone, email) : null;
    }

    public boolean deletePediatrician(int id) {
        return  getPediatricianEntity() != null ?
                getPediatricianEntity().delete(id) : false;
    }

    public boolean updatePediatrician(Pediatrician pediatrician) {
        return getPediatricianEntity() != null ?
        getPediatricianEntity().update(pediatrician):false;
    }
}
