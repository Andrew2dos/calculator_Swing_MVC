import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Viewer extends Application {

    private Controller controller;
    private TextField display;

    public Viewer() {
        controller = new Controller(this);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        // Сетка для размещения элементов
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // Поле для отображения ввода и результата
        display = new TextField();
        display.setEditable(false); // Запрещает редактирование поля
        display.setPrefWidth(128);
        display.setFont(Font.font(24)); // Размер шрифта
        grid.add(display, 0, 0, 4, 1);

        // Кнопки для цифр
        Button[] digitButtons = new Button[16];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new Button(i + "");
            digitButtons[i].setOnAction(controller);
        }

        // Кнопки для операций
        digitButtons[10] = new Button("+");
        digitButtons[11] = new Button("-");
        digitButtons[12] = new Button("*");
        digitButtons[13] = new Button("/");
        digitButtons[14] = new Button("=");
        digitButtons[15] = new Button("C");

        for (int i = 10; i < 16; i++) {
            digitButtons[i].setOnAction(controller);
        }

        // Размер и шрифт кнопок
        for (int i = 0; i < digitButtons.length; i++) {
            digitButtons[i].setFont(Font.font(28));
            digitButtons[i].setMinWidth(59);
            digitButtons[i].setMaxWidth(60);
        }

        // Размещение кнопок
        grid.add(digitButtons[1], 0, 1);
        grid.add(digitButtons[2], 1, 1);
        grid.add(digitButtons[3], 2, 1);
        grid.add(digitButtons[10], 3, 1);

        grid.add(digitButtons[4], 0, 2);
        grid.add(digitButtons[5], 1, 2);
        grid.add(digitButtons[6], 2, 2);
        grid.add(digitButtons[11], 3, 2);

        grid.add(digitButtons[7], 0, 3);
        grid.add(digitButtons[8], 1, 3);
        grid.add(digitButtons[9], 2, 3);
        grid.add(digitButtons[12], 3, 3);

        grid.add(digitButtons[15], 0, 4);
        grid.add(digitButtons[0], 1, 4);
        grid.add(digitButtons[14], 2, 4);
        grid.add(digitButtons[13], 3, 4);

        Scene scene = new Scene(grid, 340, 410);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void startJavaFXFrontendMVCRPN(String[] args) {
        launch(args);
    }

    public void update(String displayText) {
        display.setText(displayText);
    }
}
