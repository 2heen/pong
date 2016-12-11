To run the file:

Open command line/terminal inside this directory and type the following:

	If on Mac:

		bash mac_run.sh

	If on Windows:

		windows_run.bat

To change bots, open the .sh/.bat file in Sublime. On the first line (starts with ‘javac’),
change jBerney/*.java to whatever your file is called.

Example: My file is called PongBot.java and it is located in the pong folder. The first line of my .sh/.bat file would read: javac PongBog.java

If you put your bot file in a folder, please add this line to the top of your .java file:

	package folder_name;

where folder_name is the name of the folder the .java file is located in.
