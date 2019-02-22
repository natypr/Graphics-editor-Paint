package by.naty.graphicseditor.model;

import javafx.scene.canvas.GraphicsContext;


public abstract class AbstractFigure
{
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public AbstractFigure(double x1, double y1, double x2, double y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public abstract void draw(GraphicsContext context);


    public double getX1()
    {
        return x1;
    }

    public double getY1()
    {
        return y1;
    }


    public double getWidth()
    {
        return x2 - x1;
    }

    public double getHeight()
    {
        return y2 - y1;
    }

}
