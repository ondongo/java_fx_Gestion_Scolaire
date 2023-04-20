package java_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
// import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;


//
    public static void main(String[] args) {
        launch();
    }
    
       
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene((loadFXML("connect")),1230,650);
        stage.setScene(scene);
       

        stage.show();
        
    }

    public static void setRoot(String fxml) throws IOException {
        // Rectangle2D screen=Screen.getPrimary().getBounds();
        // scene.getWindow().setX(2);
        // scene.getWindow().setY(2);
        // scene.getWindow().setWidth(screen.getWidth());
        // scene.getWindow().setHeight(screen.getHeight());
        scene.setRoot(loadFXML(fxml));


        
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

  

}

