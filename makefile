output = ./bin
lib = ./bin:./lib/*
system = ./source/*.java
stub = ./stubs/*.java
unitTest = ./test/*

all: unitTest

clean:
	rm -rf bin

system:
	mkdir -p bin
	javac -g -d $(output) $(system)

stub:
	javac -g -d $(output) $(stub)

unitTest: system stub
	javac -g -cp $(lib) -d $(output) $(unitTest)

######################################################################
# unit testing
runUnitTest: runSeatUnitTest runPlaneUnitTest runRandomCodeUnitTest

runSeatUnitTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.SeatUnitTest

runPlaneUnitTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.PlaneUnitTest

runRandomCodeUnitTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.RandomCodeUnitTest

# path testing
runPlanePathTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.PlanePathTest

runSeatPathTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.SeatPathTest

runRandomCodePathTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.RandomCodePathTest

# integration testing
runIntegrationTest:
	java -cp $(lib) org.junit.runner.JUnitCore test.IntegrationTest
