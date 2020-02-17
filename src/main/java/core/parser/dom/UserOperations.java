package core.parser.dom;

import core.parser.models.User;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserOperations {

    private static final String USERS_XML = "src/main/resources/xml/users.xml";
    private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private List<User> users;

    public UserOperations() {
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(USERS_XML);
            users = new DomParserUser().parse(document);
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public List<User> getUserList() {
        return users;
    }

    public User getSpecificIdUser(int id) {
        User chosenUser = null;
        for (User user : users) {
            if (user.getId() == id) {
                chosenUser = user;
            }
        }
        return chosenUser;
    }

    public User getSpecificUser(int id, List<User> users) {
        User chosenUser = null;
        for (User user : users) {
            if (user.getId() == id) {
                chosenUser = user;
            }
        }
        return chosenUser;
    }

    public List<User> getSpecificStatusUserList(String userStatus) {
        List<User> specificUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getStatus().equals(userStatus)) {
                specificUsers.add(user);
            }
        }
        return specificUsers;
    }

    public String getUserLogin(String userStatus) {
        return getSpecificStatusUserList(userStatus).get(0).getLogin();
    }

    public String getUserPassword(String userStatus) {
        return getSpecificStatusUserList(userStatus).get(0).getPassword();
    }
}
