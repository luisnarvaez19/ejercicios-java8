package com.sci.varios;

public class Rectangle {

	static boolean intersects(Rect R1, Rect R2) {
		if ((R1.ul.x < R2.lr.x) && (R1.lr.x > R2.ul.x) && (R1.ul.y > R2.lr.y) && (R1.lr.y < R2.ul.y)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point rect1ul = new Point(1, 3);
		Point rect1br = new Point(4, 1);
		Point rect2ul = new Point(5, 1);
		Point rect2br = new Point(6, 4);
		Rect A = new Rect(rect1ul, rect1br);
		Rect B = new Rect(rect2ul, rect2br);
		System.out.println("Intersectan:  " + Rectangle.intersects(A, B));
	}

}
