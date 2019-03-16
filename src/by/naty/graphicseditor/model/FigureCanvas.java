package by.naty.graphicseditor.model;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class FigureCanvas {

    private final List<AbstractFigure> figures = new ArrayList<>();

    public void redraw(GraphicsContext context, double w, double h)
    {
        context.clearRect(0, 0, w, h);
        for (AbstractFigure figure : figures) {
            figure.draw(context);
        }
    }

    public void add(AbstractFigure figure)
    {
        figures.add(figure);
    }

    public void resizeLast(double deltaX, double deltaY)
    {
        AbstractFigure figure = figures.get(figures.size() - 1);
        figure.resize(deltaX, deltaY);
    }

    public void removeLast()
    {
        if (!figures.isEmpty()) {
            figures.remove(figures.size() - 1);
        }
    }

}
