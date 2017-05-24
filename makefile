output = ./bin
lib = ./bin:./lib/*
system = ./source/*.java
unitTest = ./test/*

all: unitTest

clean:
	rm -rf bin

system:
	mkdir -p bin
	javac -g -d $(output) $(system)

unitTest: system
	javac -g -cp $(lib) -d $(output) $(unitTest)


######################################################################

run : runSeatUnitTest

runSeatUnitTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.SeatUnitTest

runPlaneUnitTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.PlaneUnitTest

runRandomCodeUnitTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.RandomCodeUnitTest

runPlanePathTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.PlanePathTest