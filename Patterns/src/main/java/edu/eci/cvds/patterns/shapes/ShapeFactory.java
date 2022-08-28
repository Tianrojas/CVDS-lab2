package edu.eci.cvds.patterns.shapes;
import edu.eci.cvds.patterns.shapes.concrete.*;

public class ShapeFactory {
	public static Shape create(RegularShapeType type) {
		Shape retShape = null;
		switch(type) {
			case Triangle: retShape = new Triangle(); break;
			case Quadrilateral: retShape = new Quadrilateral(); break;
			case Pentagon: retShape = new Pentagon(); break;
			case Hexagon: retShape = new Hexagon(); break;
		}
		return retShape;
	}
}
