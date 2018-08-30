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

    ObservableList<List> listsData = FXCollections.observableArrayList();

    @FXML
    public void initialize(){

        firstColName.setCellValueFactory(new PropertyValueFactory<List, String>("listName"));

        secColPend.setCellValueFactory(new PropertyValueFactory<List, String>("pendingItems"));

        thirdColEst.setCellValueFactory(new PropertyValueFactory<List, String>("pendingEstimate"));

        listsTable.setItems(listsData);
    }

    public void newListWindow(ActionEvent event){
        Parent root1;
        try {
            //Cierra la actual ventana
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NuevaLista.fxml"));
            root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Nueva Lista");
            stage.setScene(new Scene(root1, 700, 500));

            //Envia la lista de listas al siguiente controller
            NuevaListaController nuevaListaController = fxmlLoader.getController();
            nuevaListaController.setListsData(listsData);

            //Muestra la nueva ventana
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void editList(ActionEvent event){
        Parent root1;
        try {
            //Cierra la actual ventana
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MiLista.fxml"));
            root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Mi Lista");
            stage.setScene(new Scene(root1, 700, 500));

            //Envia la lista de listas al siguiente controller
            MiListaController miListaController = fxmlLoader.getController();
            miListaController.setListsData(listsData);

            miListaController.setItemsData(listsTable.getSelectionModel().getSelectedItem().getItemsList());
            miListaController.setListName(listsTable.getSelectionModel().getSelectedItem().getListName());
            miListaController.setListDesc(listsTable.getSelectionModel().getSelectedItem().getListDescription());
            miListaController.pendingAmount.setText("Pendiente: " + listsTable.getSelectionModel().getSelectedItem().getPendingEstimate());
            miListaController.initialize();



            //Muestra la nueva ventana
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void deleteList(ActionEvent event){
        listsData.remove(listsTable.getSelectionModel().getSelectedItem());
    }

    public void setListsData(ObservableList<List> listsData){
        this.listsData = listsData;
    }
}
