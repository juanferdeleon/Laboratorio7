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
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import lists.List;

import java.io.IOException;

public class NuevoArticuloController {

    @FXML
    TextField itemName;

    @FXML
    TextField quant;

    @FXML
    TextField price;

    ObservableList<List> listsData = FXCollections.observableArrayList();

    String selectedList;


    public void myListWindow(ActionEvent event){
        Parent root3;
        try {
            //Crea nueva ventana
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MiLista.fxml"));
            root3 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Mi Lista");
            stage.setScene(new Scene(root3, 700, 500));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createAnItem(ActionEvent event){
        Parent root3;
        try {
            //Crea nueva ventana
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MiLista.fxml"));
            root3 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Mi Lista");
            stage.setScene(new Scene(root3, 700, 500));

            //Crea nuevo articulo
            Item item = new Item(itemName.getText(), Integer.parseInt(quant.getText()), Double.parseDouble(price.getText()));

            //Agrega el articulo a la lista seleccionada
            for (List list: listsData) {
                if (list.getListName() == selectedList){
                    list.addItem(item);
                }
            }

            //Envia toda la informacion a la nueva ventana
            MiListaController miListaController = fxmlLoader.getController();
            miListaController.setListsData(listsData);
            for (List list: listsData) {
                if (list.getListName() == selectedList){
                    miListaController.setListName(list.getListName());
                    miListaController.setListDesc(list.getListDescription());
                    miListaController.setItemsData(list.getItemsList());
                }
            }

            //Establece la lista de articulos en la nueva ventana
            miListaController.initialize();

            //Muestra la nueva ventana
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setListsData(ObservableList<List> listData){//Recibe la lista de listas
        this.listsData = listData;
    }

    public void setSelectedList(String selectedList){//Recibe el nombre de la lista seleccionada
        this.selectedList = selectedList;
    }

}
