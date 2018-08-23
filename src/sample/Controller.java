package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lists.List;

import java.io.IOException;

public class Controller {

    @FXML
    TableView<List> listsTable;

    @FXML
    TableColumn firstColName;

    @FXML
    TableColumn secColPend;

    @FXML
    TableColumn thirdColEst;

    @FXML
    public void initialize(){
        ObservableList<List> data = FXCollections.observableArrayList();

        firstColName.setCellValueFactory(new PropertyValueFactory<List, String>("listName"));

        secColPend.setCellValueFactory(new PropertyValueFactory<List, String>("pendingItems"));

        thirdColEst.setCellValueFactory(new PropertyValueFactory<List, String>("pendingEstimate"));
    }

    public void newListWindow(ActionEvent event){
        Parent root1;
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NuevaLista.fxml"));
            root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Nueva Lista");
            stage.setScene(new Scene(root1, 700, 500));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
