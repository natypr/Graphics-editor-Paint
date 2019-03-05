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

    public void resizeLast(double deltaX, double deltaY)
    {
        // require(!figures.isEmpty(), "no figure to resize");
        AbstractFigure figure = figures.get(figures.size() - 1);
        figure.resize(deltaX, deltaY);
    }

}
