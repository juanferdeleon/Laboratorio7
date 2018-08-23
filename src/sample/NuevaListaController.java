package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lists.List;

import java.io.IOException;

public class NuevaListaController {

    @FXML
    TextField nameField;

    @FXML
    TextField descField;

    public void sampleWindow(ActionEvent event){
        Parent root1;
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
            root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Mis Listas");
            stage.setScene(new Scene(root1, 700, 500));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createList(ActionEvent event){
        Parent root1;
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MiLista.fxml"));
            root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Mi Lista");
            stage.setScene(new Scene(root1, 700, 500));

            List newList = new List(nameField.getText(), descField.getText());
            MiListaController miListaController = fxmlLoader.getController();

            miListaController.setListName(newList.getListName());
            miListaController.setListDesc(newList.getListDescription());

            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
