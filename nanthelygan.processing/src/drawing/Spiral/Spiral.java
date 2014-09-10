package nanthelygan.processing;

import processing.core.*;

public class Spiral {
	
	private PApplet _parent;
	private int _centerX;
	private int _centerY;
	private float _startAngle;
	private float _endAngle;
	private float _angleStep;
	private float _initialRadius;
	private float _radiusIncrement;
	private boolean _enableNoise;
	private float _radiusNoise;

	public Spiral(PApplet parent, SpiralSettings settings) {
		_parent = parent;
		_centerX = settings.CenterX;
		_centerY = settings.CenterY;
		_startAngle = settings.StartAngle;
		_endAngle = settings.EndAngle;
		_angleStep = settings.AngleStep;
		_initialRadius = settings.InitialRadius;
		_radiusIncrement = settings.RadiusIncrement;
		_enableNoise = settings.EnableNoise;
		_radiusNoise = _parent.random(10);
	}

	public void Draw() {
		float radius = _initialRadius;
		float x, y;
		float lastX = -999;
		float lastY = -999;
		for (float angle = _startAngle; angle <= _endAngle; angle += _angleStep) {
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