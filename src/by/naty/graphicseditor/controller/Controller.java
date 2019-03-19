package by.naty.graphicseditor.controller;

import by.naty.graphicseditor.model.AbstractFigure;
import by.naty.graphicseditor.model.FigureCanvas;
import by.naty.graphicseditor.model.FigureType;
import by.naty.graphicseditor.model.FigureFactory;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.*;
import javafx.scene.paint.Color;

public class Controller {

    // our declarations

    private final KeyCombination undo = new KeyCodeCombination(KeyCode.Z, KeyCombination.SHORTCUT_DOWN);
    private final FigureCanvas figureCanvas = new FigureCanvas();
    private double dragPrevX = -1.0;    //
    private double dragPrevY = -1.0;
    private State state = State.Cursor;

    // form declarations

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
        state = State.Dragging;
        switch (state) {
            case Cursor:
                break;
            case Dragging:
                dragPrevX = (int) event.getX();
                dragPrevY = (int) event.getY();

                FigureType figureType = getSelectedFigureType();
                AbstractFigure figure = FigureFactory.create(figureType, dragPrevX, dragPrevY);

                figureCanvas.add(figure);
                figureCanvas.redraw(mainCanvas.getGraphicsContext2D(), mainCanvas.getWidth(), mainCanvas.getHeight());
                break;
            case Selecting:
                break;
            default:
                break;
        }
    }

    @FXML
    public void canvasOnMouseDragged(MouseEvent event)
    {
        if (state == State.Dragging) {

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

    @FXML
    public void canvasOnKeyPressed(KeyEvent event)
    {
        if (undo.match(event)) {
            figureCanvas.removeLast();
            figureCanvas.redraw(mainCanvas.getGraphicsContext2D(), mainCanvas.getWidth(), mainCanvas.getHeight());
        }
    }

    private FigureType getSelectedFigureType()
    {
        FigureType[] available = {  FigureType.Rectangle,
                                    FigureType.Square,
                                    FigureType.Oval,
                                    FigureType.Circle,
                                    FigureType.Triangle,
                                    FigureType.Line
        };
        return available[5];
    }
}
