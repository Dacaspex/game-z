# game-z
Test game written in LWJGL and Slick2D

## Installation intructions
1. Download Slick2D from http://slick.ninjacave.com/.
2. Create a new folder `lib/slick2D` and copy all the contents of the Slick2D zip into that.
3. Inside the Slick2D folder there is another folder called lib. Add the following jars as dependencies to the project
  - `slick.jar`
  - `lwjgl.jar`
  - `lwjgl_util.jar`
  - `jinput.jar`
4. Add the following to the VM options: `-Djava.library.path=lib/Slick2D/`
5. Compile and you're good to go!
