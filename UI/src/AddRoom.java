import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import timetable.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


/**
 *
 * @author brianbett
 */
public class AddRoom implements Initializable{
    
    //For the TextFields
    @FXML private TextField roomName;
    @FXML private TextField capacity;
    
    //For The radioButtons
    @FXML private RadioButton isLabYes;
    @FXML private RadioButton isLabNo;
    @FXML private RadioButton disYes;
    @FXML private RadioButton disNo;
    private boolean labState =false;
    private boolean disState= false;
    
    private Room room;
    
    private ToggleGroup isLabToggle;
    private ToggleGroup disToggle;
    
    public void backButt(ActionEvent event) throws IOException{
        Parent backBut = FXMLLoader.load(getClass().getResource("manageTimetable.fxml"));
        Scene backButScene = new Scene(backBut);
        
        Stage addRoomWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(backButScene);
        addRoomWindow.show();
    }
    
    public void okAddRoom(ActionEvent event) throws IOException{
        Parent backBut = FXMLLoader.load(getClass().getResource("manageTimetable.fxml"));
        Scene backButScene = new Scene(backBut);
        
        Stage addRoomWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(backButScene);
        addRoomWindow.show();
        
        String insert = "INSERT INTO `ttproj`.`room`(`capacity`, `name`) VALUES (`"+capacity+"`,`"+roomName+"`)";
        
        Conn conn = new Conn();
        conn.logon(insert);
    }

    /**
     * 
     * @param location
     * @param resources 
     */
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        isLabToggle = new ToggleGroup();
        isLabNo.setToggleGroup(isLabToggle);
        isLabYes.setToggleGroup(isLabToggle);
        
        disToggle  = new ToggleGroup();
        disNo.setToggleGroup(disToggle);
        disYes.setToggleGroup(disToggle);

        if (disYes.isSelected()){
            disState = true;
        }
        if (isLabYes.isSelected()){
            labState = true;
        }
    }
}
