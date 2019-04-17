package by.naty.graphicseditor.controller;

import by.naty.graphicseditor.model.AbstractFigure;
import by.naty.graphicseditor.model.FigureCanvas;
import by.naty.graphicseditor.model.FigureType;
import by.naty.graphicseditor.model.FigureFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;

public class Controller {

    // our declarations

    private final KeyCombination undo = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN);
    private final KeyCombination redo = new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN);
    private final FigureCanvas figureCanvas = new FigureCanvas();
    private double dragPrevX = -1.0;
    private double dragPrevY = -1.0;
    private State state = State.Selecting;

    // form declarations

    @FXML
    private Canvas mainCanvas;

    @FXML
    private ColorPicker colPen;

    @FXML
    public ColorPicker colFill;

    @FXML
    private ListView<FigureType> lwMain;

    @FXML
    void initialize()
    {
        colPen.setValue(Color.BLACK);
        colFill.setValue(Color.RED);
        lwMain.getItems().addAll(FigureType.values());
        lwMain.getSelectionModel().selectFirst();

    }

    @FXML
    public void canvasOnMousePressed(MouseEvent event) {
        if (isSelecting()) {
            state = State.Selecting;
        }
        else {
            state = State.Dragging;
        }

        dragPrevX = (int) event.getX();
        dragPrevY = (int) event.getY();
        switch (state) {
            case Dragging:
                FigureType figureType = getSelectedFigureType();
                AbstractFigure figure = FigureFactory.getInstance().create(figureType, dragPrevX, dragPrevY);
                figure.setFillColor(colFill.getValue().toString());
                figure.setPenColor(colPen.getValue().toString());

                figureCanvas.add(figure);
                figureCanvas.redraw(mainCanvas.getGraphicsContext2D(), mainCanvas.getWidth(), mainCanvas.getHeight());
                break;
            case Selecting:
                figureCanvas.selectAndRedraw(event.getX(), event.getY(), mainCanvas.getGraphicsContext2D(), mainCanvas.getWidth(), mainCanvas.getHeight());
                break;
        }
    }

    @FXML
    public void canvasOnMouseDragged(MouseEvent event)
    {
        double newX = event.getX();
        double newY = event.getY();
        double deltaX = newX - dragPrevX;
        double deltaY = newY - dragPrevY;
        dragPrevX = newX;
        dragPrevY = newY;

        switch (state) {
            case Dragging:
                figureCanvas.resizeLast(deltaX, deltaY);
                figureCanvas.redraw(mainCanvas.getGraphicsContext2D(), mainCanvas.getWidth(), mainCanvas.getHeight());
                break;
            case Selecting:
                figureCanvas.moveSelected(deltaX, deltaY);
                figureCanvas.redraw(mainCanvas.getGraphicsContext2D(), mainCanvas.getWidth(), mainCanvas.getHeight());
                break;
        }
    }

    @FXML
    public void canvasOnKeyPressed(KeyEvent event)
    {
        if (undo.match(event)) {
            figureCanvas.removeLast();
            figureCanvas.redraw(mainCanvas.getGraphicsContext2D(), mainCanvas.getWidth(), mainCanvas.getHeight());
        }
        if(redo.match(event)){
            figureCanvas.redo();
            figureCanvas.redraw(mainCanvas.getGraphicsContext2D(), mainCanvas.getWidth(), mainCanvas.getHeight());
        }
    }

    private FigureType getSelectedFigureType()
    {
        return lwMain.getFocusModel().getFocusedItem();
    }

    private boolean isSelecting()
    {
        return getSelectedFigureType() == FigureType.Selection;
    }



    public void openFile(ActionEvent actionEvent) {

    }

    public void saveFile(ActionEvent actionEvent) {
    }
}
