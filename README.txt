Dungeon Dimensions:
Date: 5/11/2014

Author: Nick Frank

This is a game written in Java for my CS442 - Software Engineering class. This was an example project to  demonstrate good project management,
group software development using source and revision control, and knowledge of software engineering and the agile process involving writing user stories,
tracking development time and use of burndown and Gantt charts etc.

The inspiration behind the game was the top down grid based movement of the classic Legend of Zelda for the original Nintendo. We were able to implement a
map loading and 'creation' system, by reading in text files that define our maps containing an array of characters of a certain width and height that can be
interpreted by the program and drawn as tiles.

Enemy AI and movement isn't complete other than having them fire projectiles on a timer. They do not follow the player or cause damage yet, however the player can cause damage
to the environment and enemies as he or see sees fit.

Options menu is not fully implemented and difficulty does not actually affect anything.

I tried my best to also make this a good example of polymorphism and inheritance as a lot of the tile classes needed specific attributes yet generally behaved the same,
I could do a lot of code reuse.

All of the pixel art was done in MS PAINT or GIMP zoomed in 800% drawing pixel by pixel by myself or my group.

Controls:
Movement - WASD

Up      - W
Down    - A
Left    - S
Right   - D

Attack  - Space

Use Key - E


