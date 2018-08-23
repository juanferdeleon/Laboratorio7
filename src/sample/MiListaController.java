package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MiListaController {

    @FXML
    Label listName;

    @FXML
    Label listDesc;

    public void setListName(String name){
        this.listName.setText(name);
    }

    public void setListDesc(String desc){
        this.listDesc.setText(desc);
    }

    public void newListWindow(ActionEvent event){
        Parent root2;
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NuevaLista.fxml"));
            root2 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Nueva Lista");
            stage.setScene(new Scene(root2, 700, 500));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addItem(ActionEvent event){
        Parent root2;
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NuevoArticulo.fxml"));
            root2 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Nuevo Articulo");
            stage.setScene(new Scene(root2, 700, 500));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
