import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Controller implements EventHandler<ActionEvent> {

    public Model model;
    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    public void handle(ActionEvent event) {
        Button button = (Button) event.getTarget();
        String textButton = button.getText();
        String command = "";

        switch (textButton) {
            case "0":
                command = "Zero";
                break;
            case "1":
                command = "One";
                break;
            case "2":
                command = "Two";
                break;
            case "3":
                command = "Three";
                break;
            case "4":
                command = "Four";
                break;
            case "5":
                command = "Five";
                break;
            case "6":
                command = "Six";
                break;
            case "7":
                command = "Seven";
                break;
            case "8":
                command = "Eight";
                break;
            case "9":
                command = "Nine";
                break;
            case "+":
                command = "Plus_Command";
                break;
            case "-":
                command = "Minus_Command";
                break;
            case "*":
                command = "Multiply_Command";
                break;
            case "/":
                command = "Divide_Command";
                break;
            case "=":
                command = "Equals_Command";
                break;
            case "C":
                command = "Clear_Command";
                break;
            default:
                break;

        }
        model.doAction(command);
    }
}

