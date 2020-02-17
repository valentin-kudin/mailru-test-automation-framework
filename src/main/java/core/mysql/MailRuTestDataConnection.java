package core.mysql;


import core.mysql.models.Letter;
import core.util.random.RandomOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailRuTestDataConnection {

    private String url = "jdbc:mysql://localhost:3306/mailrutestdata?useSSL=false";
    private String user = "root";
    private String password = "rootvlh";

    public String getSelectQuery(String table, String columnName, String columnValue) {
        return String.format("SELECT * FROM mailrutestdata.letterdata WHERE %s = %s;", columnName, columnValue);
    }

    public String getSelectQueryForList(String table) {
        return String.format("SELECT * FROM mailrutestdata.%s;", table);
    }

    public List<Letter> getLetterListFromDataBase() {
        List<Letter> letterList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getSelectQueryForList("letterdata"))) {
            while (resultSet.next()) {
                Letter letter = new Letter();
                letter.setLetterId(Integer.parseInt(resultSet.getString("letterid")));
                letter.setAddressee(resultSet.getString("addressee"));
                letter.setSubject(resultSet.getString("subject"));
                letter.setMessage(resultSet.getString("message"));
                letterList.add(letter);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return letterList;
    }

    public Letter getRandomLetterFromDatabase() {
        List<Letter> letterList = getLetterListFromDataBase();
        int randomIndex = RandomOperations.getRandomNumber(0, letterList.size() - 1);
        return letterList.get(randomIndex);
    }

    public Letter getSpecificLetterFromDatabase(int listIndex) {
        return getLetterListFromDataBase().get(listIndex);
    }
}
