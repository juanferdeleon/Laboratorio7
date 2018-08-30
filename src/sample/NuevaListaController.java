package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    ObservableList<List> listsData = FXCollections.observableArrayList();

    public void sampleWindow(ActionEvent event){
        Parent root1;
        try {
            //Crea nueva ventana
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
            root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Mis Listas");
            stage.setScene(new Scene(root1, 700, 500));

            //Envia la informacion de listas y la despliega
            Controller controller = fxmlLoader.getController();
            controller.setListsData(listsData);
            controller.initialize();

            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createList(ActionEvent event){
        Parent root1;
        try {
            //Crea nueva ventana
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MiLista.fxml"));
            root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Mi Lista");
            stage.setScene(new Scene(root1, 700, 500));

            //Crea la lista
            List newList = new List(nameField.getText(), descField.getText());

            //Agrega la nueva lista
            listsData.add(newList);

            //Muestra el nombre y la descripcion de la nueva lista, envia la lista de listas.
            MiListaController miListaController = fxmlLoader.getController();
            miListaController.setListName(newList.getListName());
            miListaController.setListDesc(newList.getListDescription());
            miListaController.setListsData(listsData);

            //Muestra la nueva ventana
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setListsData(ObservableList<List> listData){
        this.listsData = listData;
    }

}
