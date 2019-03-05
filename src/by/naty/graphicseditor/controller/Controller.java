package by.naty.graphicseditor.controller;

import by.naty.graphicseditor.model.AbstractFigure;
import by.naty.graphicseditor.model.FigureCanvas;
import by.naty.graphicseditor.model.figures.Rectangle;
import by.naty.graphicseditor.model.figures.Triangle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {

    private final FigureCanvas figureCanvas = new FigureCanvas();
    private double dragPrevX = -1.0;
    private double dragPrevY = -1.0;


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

        AbstractFigure trg = new Triangle(clickedX, clickedY, clickedX + 100, clickedY + 50);
        trg.draw(mainCanvas.getGraphicsContext2D());
    }

    @FXML
    public void canvasOnMouseDragged(MouseEvent event)
    {
        double newX = event.getX();
        double newY = event.getY();
        double deltaX = newX - dragPrevX;
        double deltaY = newY - dragPrevY;
        figureCanvas.resizeLast(deltaX, deltaY);
        figureCanvas.redraw(mainCanvas.getGraphicsContext2D(), mainCanvas.getWidth(), mainCanvas.getHeight());
        dragPrevX = newX;
        dragPrevY = newY;

    }
}
