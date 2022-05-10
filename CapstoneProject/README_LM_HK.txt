AP Computer Science Final Project - README Template


Instructions:
The first step in creating an excellent APCS final project is to write up a README. At this stage, this README file acts as your project proposal. Once you’ve filled in all components, Shelby will read through it and suggest edits. Ultimately, you need a document that adequately describes your project idea and we must agree on this plan.


Have one member of your group make a copy of this Google Doc. Then, they should share it with all other members and with Mr. Shelby so that every group member has edit permissions, and Shelby can add comments on your ideas.


There’s a lot of parts of this document that you might not have full answers for yet. Because you haven’t written the program yet, it’s difficult to think about the instructions or which group members will do which parts. Even though this is hard to think about, you must have something in these sections that acts as your current plan. However, during the course of the project, you’ll continuously update this document. This means that you will not be held to exactly what you put here - components of this document can change (and it’s pretty common!).


There is one exception: the Features List section. Once Shelby OKs your README, the Features List section cannot be modified. For this reason, it is most important that you get a solid idea of what you want to make and the primary features it will have now.


Talk with your group. Consider drawing some pictures of what you think your project might look like. Be precise. When you’re ready, fill this out together. Each component in brackets below ( [these things] ) should be replaced with your ideas. Note that there are several sample READMEs posted on this assignment for you to use as guidance.


-------------------When README is finalized, remove everything above this line--------------------


“Redline”
Authors: Luke M, Hayden K
Revision: 4/12/22


Introduction: 
[In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
What does your program do? It is a racing game where the main character has to race a set number of levels. Kind of like F1
What problem does it solve? Why did you write it? We wrote it to entertain people with a game that had the features many racing games usually lack.


What is the story[a]?
* Freaky friday situation? (“bob” gets bodyswapped w/champion racer)
What are the rules? What is the goal? “Bob”(we don’t have a name for the main character yet) must win a certain number of races or levels (the type, such as timed or getting a specific place, varies with the level, there will be a Level superclass and maybe either a class for each level or a class for each TYPE of level) to save his favorite racer’s career, and once he accomplishes that, he gets bodyswapped back.
Who would want to use your program?[b][c] (the view is from the top of the car, it is a bird’s-eye view)
Kids, racing enthusiasts, gamers
What are the primary features of your program?
Cars, tracks, levels, racing, championships, glory, etc.


Instructions:
[Explain how to use the program. This needs to be specific: 
Which keyboard keys will do what? For single-player mode (the mode with AI: The left/right arrow keys will steer, the up arrow will accelerate, and the down arrow will brake. Double-player mode will apply all of the above features, but with the WASD keys for the second player. In any mode, the space bar will pause the game and show the controls or resume the game and hide the controls. Also we might include the Konami Code as a possible Easter egg[d][e].
Where will you need to click? 
Will you have menus that need to be navigated? What will they look like? 
Do actions need to be taken in a certain order?]


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
* Working physics & collisions, such as the cars driving realistically and colliding realistically. They should not stay stuck together or go through each other, and the car should collide with the edge of the road or veer off the road realistically.
* The animation would be detailed, but it might still look 2D. The cars will have details, but they still might be simple 2D rectangles.
* Background scenery (trees, weather, etc.) The weather might occasionally change (although this will not have any effect on gameplay, it simply changes the background from sun to rain, for example). There will be occasional trees, rocks, signs, etc. depending on the course or level.
* The ability to have a score/high score and save it, such as with File I/O[f][g]. The program should also be able to recognize where you are in the game and not force you to replay the whole game if you restart it.
* There should be a set number of levels that each have a distinctive layout. There would be certain categories of levels (timed, non-timed, special environment levels, etc.)[h]


Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
* Local/online multiplayer should be available, as well as a combination of each. You should be able to play against someone on your own computer, as well as against other computers in the same room, or against bots, or with a combination of all the above.
* Easter eggs such as the Konami code doing something. This might include giving you some reward, unlocking a secret level, or simply showing you a cool Easter egg such as a hidden picture. There would also be things such as hidden messages in the game. If there’s a level with black and white tiles on the screen somewhere, or a bunch of binary code, it would probably be an encoded hidden message, maybe “Hello World” or “You lost the game” (a reference to The Game: http://losethegame.com).
* Levels that are unusual or have a different environment. An example of this would be a level that is backwards, or a level with all the colors inverted.
* The ability to compare your high scores with others online. The program will save your high score, but ideally it would also compare yours with others and have a leaderboard.
* A dramatic finale, as opposed to just “you completed the game”. This would have such features as a resolution of the story, a small animated part explaining what happens after the game is completed, or a list of credits (which would admittedly be very small, or feature a list of joke names).


Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
* AI cars that make their own decisions. The current visualization for the cars is just cars that follow a preprogrammed set of directions.
*  The ability to make your own levels/share them. This would have to not interfere with the preexisting levels or their order.
* Actual intro scenes instead of text. The introduction would introduce you to the story, but do so in a purely text-based way.
* More detailed animation. The cars might have shadows or edges to make them seem less 2D. The environment might also be made less two-dimensional.




Class List:
* Main - displays the screen
* Track
* BotCar
   * Split off into different models?
   * Each will have physics properties: Top speed, acceleration, cornering, etc.
* Player
* Statistics - for things like saving a high score, it will implement File I/O
* Background - this will take care of the background imagery




Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
* List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
* Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.][i]


[a]introduction should be made into a paragraph that tells you the central idea without confusion
[b]Will there be certain levels? Who is Bob going to race against? Will it be like a timed run where you have to complete the course in a certain time limit, or will you try and compete against the computer.
[c]Will the view be from the back, side, or front
[d]Unclear what the point of single player game is unless AI but will be very hard to implement
[e]added some more detail
[f]must have features and all features are very vague and could be said about any game.
[g]added detail
[h]I think we need to add something about other non-player cars. Will there be computer players? Or is it multiplayer? It seems like one of these needs to be a must-have feature.
[i]There should be something here at this point.