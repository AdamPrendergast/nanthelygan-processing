package nanthelygan.processing;

import processing.core.*;

public class DrawingFactory {
	
	PApplet _parent;
	
	public DrawingFactory(PApplet parent) {
		_parent = parent;
	}
	
	public Spiral Spiral(int centerX, int centerY, float spiralAngleLength, float initialRadius, float radiusIncrement) {
		return new Spiral(_parent, centerX, centerY, spiralAngleLength, initialRadius, radiusIncrement);
	}
	
}