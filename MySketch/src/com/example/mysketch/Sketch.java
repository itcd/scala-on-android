package com.example.mysketch;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

/// https://processing.org/examples/pattern.html

public class Sketch extends PApplet {
	public void settings() {
		size(displayWidth, displayHeight);
	}

	@Override
	public void setup() {
		background(102);
	}

	public void variableEllipse(int x, int y, int px, int py) {
		float speed = abs(x - px) + abs(y - py);
		stroke(speed);
		ellipse(x, y, speed, speed);
	}

	@Override
	public void draw() {
		variableEllipse(mouseX, mouseY, pmouseX, pmouseY);
	}

	static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "Sketch" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
}
