package nanthelygan.processing;

import processing.core.*;

public class Spiral {
	
	private PApplet _parent;
	private int _centerX;
	private int _centerY;
	private float _spiralAngleLength;
	private float _initialRadius;
	private float _radiusIncrement;
	private boolean _enableNoise;
	private float _radiusNoise;

	Spiral(PApplet parent, int centerX, int centerY, float spiralAngleLength, float initialRadius, float radiusIncrement) {
		_parent = parent;
		_centerX = centerX;
		_centerY = centerY;
		_spiralAngleLength = spiralAngleLength;
		_initialRadius = initialRadius;
		_radiusIncrement = radiusIncrement;
		_enableNoise = false;
		_radiusNoise = _parent.random(10);
	}

	public void Draw() {
		float radius = _initialRadius;
		float x, y;
		float lastX = -999;
		float lastY = -999;
		for (float angle = 0; angle <= _spiralAngleLength; angle += 5) {
			radius += _radiusIncrement;
			float thisRadius = CalculateRadius(radius);
			float rad = _parent.radians(angle);
			x = _centerX + (thisRadius * _parent.cos(rad));
			y = _centerY + (thisRadius * _parent.sin(rad));
			if (lastX > -999) {
				_parent.line(x, y, lastX, lastY);
			}
			lastX = x;
			lastY = y;
		}
	}
	
	public void EnableNoise() {
		_enableNoise = true;
	}
	
	public void DisableNoise() {
		_enableNoise = false;
	}
	
	private float CalculateRadius(float radius) {
		if (_enableNoise) {
			_radiusNoise += 0.05;
			return radius + (_parent.noise(_radiusNoise)*200) - 100;
		} else {
			return radius;
		}
	}
}