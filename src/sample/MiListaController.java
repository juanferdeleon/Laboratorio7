package sample;

import items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lists.List;

import java.io.IOException;

public class MiListaController {

    @FXML
    Label listName;

    @FXML
    Label listDesc;

    @FXML
    Label pendingAmount;

    @FXML
    TableView<Item> itemsTable;

    @FXML
    TableColumn itemName;

    @FXML
    TableColumn itemPrice;

    @FXML
    TableColumn itemQuant;

    @FXML
    TableColumn itemTotal;

    @FXML
    TableColumn itemState;

    ObservableList<Item> itemsData = FXCollections.observableArrayList();

    ObservableList<List> listsData = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        itemName.setCellValueFactory(
                new PropertyValueFactory<Item, String>("itemName")
        );
        itemPrice.setCellValueFactory(
                new PropertyValueFactory<Item, String>("itemPrice")
        );
        itemQuant.setCellValueFactory(
                new PropertyValueFactory<Item, String>("itemQuant")
        );
        itemTotal.setCellValueFactory(
                new PropertyValueFactory<Item, String>("itemTotal")
        );
        itemState.setCellValueFactory(
                new PropertyValueFactory<Item, Boolean>("isPending")
        );

        itemsTable.setItems(itemsData);
    }

    public void setListName(String name){
        this.listName.setText(name);
    }

    public void setListDesc(String desc){
        this.listDesc.setText(desc);
    }

    public void sampleWindow(ActionEvent event){
        Parent root2;
        try {
            //Crea nueva ventana
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sample.fxml"));
            root2 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Mis Listas");
            stage.setScene(new Scene(root2, 700, 500));

            //Envia la informacion de las listas
            Controller controller = fxmlLoader.getController();
            controller.setListsData(listsData);

            //Despliega las listas
            controller.initialize();

            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void newItem(ActionEvent event){
        Parent root2;
        try {
            //Crea ventana de un nuevo articulo
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NuevoArticulo.fxml"));
            root2 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Nuevo Articulo");
            stage.setScene(new Scene(root2, 700, 500));

            //Envia la informacion de las listas y la lista seleccionada
            NuevoArticuloController nuevoArticuloController = fxmlLoader.getController();
            nuevoArticuloController.setListsData(listsData);
            nuevoArticuloController.setSelectedList(listName.getText());

            //Muestra la nueva ventana
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pendingItem(ActionEvent event){
        itemsTable.getSelectionModel().getSelectedItem().isPending();
        itemsTable.refresh();
        for (List list: listsData) {
            if (list.getListName().equals(listName)){
                list.setItemsList(itemsData);
                this.pendingAmount.setText("Pendiente: " + list.getPendingEstimate());
            }
        }
    }

    public void notPendingItem(ActionEvent event){
        itemsTable.getSelectionModel().getSelectedItem().isNotPending();
        itemsTable.refresh();
        for (List list: listsData) {
            if (list.getListName().equals(listName)){
                list.setItemsList(itemsData);
            }
        }
    }

    public void setListsData(ObservableList<List> listData){
        this.listsData = listData;
    }

    public void setItemsData(ObservableList<Item> itemsData){
        this.itemsData = itemsData;
    }

}
