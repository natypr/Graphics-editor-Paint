package by.naty.graphicseditor.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FigureCanvas {

    private static final int SELECTION_PADDING = 8;
    private final List<AbstractFigure> figures = new ArrayList<>();
    private AbstractFigure selected = null;

    private final Stack<AbstractFigure> redo = new Stack<>();

    public void redraw(GraphicsContext context, double w, double h)
    {
        context.clearRect(0, 0, w, h);
        for (AbstractFigure figure : figures) {
            figure.draw(context);
        }
        if (selected != null) {
            context.setStroke(Color.GREEN);
            context.setLineWidth(2);
            context.setLineDashes(20);
            context.strokeRect(
                    selected.getX1() - SELECTION_PADDING,
                    selected.getY1() - SELECTION_PADDING,
                    selected.getWidth() + 2 * SELECTION_PADDING,
                    selected.getHeight() + 2 * SELECTION_PADDING);
            context.setLineDashes(0);
        }
    }

    public void add(AbstractFigure figure)
    {
        figures.add(figure);
        redo.clear();
    }

    public void resizeLast(double deltaX, double deltaY)
    {
        AbstractFigure figure = figures.get(figures.size() - 1);
        figure.resize(deltaX, deltaY);
    }

    public void removeLast()
    {
        if (!figures.isEmpty()) {
            redo.add(figures.get(figures.size() - 1));
            figures.remove(figures.size() - 1);
        }
    }

    public void redo()
    {
        if (!redo.isEmpty()) {
            figures.add(redo.pop());
        }
    }

    public void selectAndRedraw(double x, double y, GraphicsContext context, double w, double h)
    {
        AbstractFigure newSelected = getSelected(x, y);
        if (selected != newSelected) {
            selected = newSelected;
            redraw(context, w, h);
        }
    }

    private AbstractFigure getSelected(double x, double y)
    {
        for (int i = figures.size() - 1; i >= 0; i--) {
            AbstractFigure figure = figures.get(i);
            if (figure.contains(x, y)) {
                return figure;
            }
        }
        return null;
    }

    public void moveSelected(double deltaX, double deltaY)
    {
        if (selected != null) {
            selected.moveDelta(deltaX, deltaY);
        }
    }
}
