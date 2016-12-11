export JAVA_HOME=`/usr/libexec/java_home -v 1.7.0_79`

javac -target 1.7 jberney/*.java

java edu/berkeley/atdp/java/game/pong/PongGame Keyboard jberney.LazyRight