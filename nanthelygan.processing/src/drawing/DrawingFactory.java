package nanthelygan.processing;

import processing.core.*;

public class DrawingFactory {
	
	PApplet _parent;
	
	public DrawingFactory(PApplet parent) {
		_parent = parent;
	}
	
	public Spiral Spiral(SpiralSettings settings) {
		return new Spiral(_parent, settings);
	}
	
}