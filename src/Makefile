JC = javac -g
JR = jar -c -f ../sorting-tool.jar -e diversity.arrays.SortingTool
SRC = diversity/arrays/

ifeq ($(OS),Windows_NT)
	RM = del /F /Q
	SP = $(subst /,\,$(SRC))
else
	RM = rm -f
	SP = $(SRC)
endif

.SUFFIXES: .java .class

.java.class:
	$(JC) $*.java

CLASSES = \
		$(SRC)LogFormatter.java \
		$(SRC)ToolLogger.java \
		$(SRC)ArgsParser.java \
		$(SRC)FileHolder.java \
		$(SRC)DataHolder.java \
		$(SRC)DeepCompare.java \
		$(SRC)SortingTool.java

default: compile

compile: $(CLASSES:.java=.class)

install: compile
	$(JR) $(SRC)*.class

clean:
	$(RM) $(SP)*.class