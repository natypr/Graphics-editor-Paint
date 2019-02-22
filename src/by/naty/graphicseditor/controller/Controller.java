package by.naty.graphicseditor.controller;

import by.naty.graphicseditor.model.AbstractFigure;
import by.naty.graphicseditor.model.figures.Rectangle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private Canvas mainCanvas;

    @FXML
    private ColorPicker colPen;

    @FXML
    public ColorPicker colFill;

    @FXML
    void initialize()
    {
        colPen.setValue(Color.GREEN);
        colFill.setValue(Color.RED);

    }

    @FXML
    public void canvasOnMousePressed(MouseEvent event) {
        int clickedX = (int) event.getX();
        int clickedY = (int) event.getY();

        AbstractFigure trg = new Rectangle(clickedX, clickedY, clickedX + 100, clickedY + 50);
         trg.draw(mainCanvas.getGraphicsContext2D());
    }

    @FXML
    public void canvasOnMouseDragged(MouseEvent event)
    {

    }
}
