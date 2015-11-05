package com.example.mysketch

/// https://processing.org/examples/recursion.html

class ScalaSketch extends Sketch {
  override def setup(): Unit = {
    noStroke()
    noLoop()
  }

  override def draw(): Unit = {
    drawCircle(width / 2, 280, 6)
  }

  def drawCircle(x: Int, radius: Int, level: Int): Unit = {
    val tt = 126f * level / 4.0f;
    fill(tt);
    ellipse(x, height / 2, radius * 2, radius * 2);
    if (level > 1) {
      val n = level - 1;
      drawCircle(x - radius / 2, radius / 2, n);
      drawCircle(x + radius / 2, radius / 2, n);
    }
  }
}
