# Screensaver
PROG1400 Assign 5: Basic Screensaver and moving graphics

Submission notes:
- click on the screen to add objects to canvas. There are four shapes each with their own form of mutation.
- Had some trouble getting proper edge detection on rotating star shape some overlap occurs with walls in certain instances.
- Collision detection is imperfect. I've used bounding rectangles of each shape and can detect collision but the deflection angles are not perfect (only x direction inverts).


Initial Request
Programming Assignment Rubric
Assignment: # 5
PROG 1400

Important note: This is a simulated screen saver and as such it does not have to link into your operating system as a ‘real’ screen saver would.

Assignment # 5 (individual)

Write a screen saver application that simulates a screen saver. The application:

•	Must contain at least four moving shapes
•	One of the shapes must be an irregular one (e.g. polygon) from the Java2D API – General Path and move using transitions.
•	It must demonstrate a variety of (at least four) unique visual state changes (e.g. color, gradients, size, etc). 
•	You must create a class for each object you wish to draw. (E.g. triangle) that are subclasses of a super class called shapes.
•	In order to draw the shapes your program must demonstrate polymorphic processing by using a timer object to iterate through an array list of type shape into which all the sub-classes of superclass shape have been explicitly cast 
•	 The shapes must bounce off the walls (see provided algorithm)
•	The shapes’ bouncing should respond to changes made to the panel / frame size. 
•	Additional shapes may be added to the panel at run time using a control, mouse or key event.


Notes: 
•	Changing color, changing gradient, painting using the buffer (e.g. plaid), and changing size, changing shape, etc. all count as SEPARATE changes. You only need to apply them once each (preferably not all to one single shape) but two on one shape is ok.
