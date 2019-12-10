# Java Sorting Tool

This is a kind of command-line sorting tool for the data read from an arbitrary CSV file that has two mandatory fields named “row” and “column”. The tool sorts data according to the field names inputted from the command-line. For the numerical data, it sorts the value from the highest to the lowest. For anything else, it sorts the value in alphabetical order. The output of this tool is the top 3 results in the YAML format. This tool supports multiple fields sorting, which means sorting process begins from the first field, and use the next field to break the tie. The number of fields can be arbitrary.

## Quick Start

- **Download or clone this tool to your computer**  
~~~
  $ git clone https://github.com/Aplombird/java-sorting-tool.git  
~~~

- **Enter the folder of this tool**
~~~
  $ cd java-sorting-tool  
~~~

- **Run the tool with field names you want to sort**  
~~~
  $ java -jar sorting-tool.jar ENTRY_NO PH_cm EH_cm  
~~~

- **The tool direct outputs the results as you want**
~~~
  Tue Dec 10 22:27:42 AEDT 2019::INFO::Welcome to use this sorting tool.
  Tue Dec 10 22:27:42 AEDT 2019::INFO::Parsing inputted command-line arguments ...
  Tue Dec 10 22:27:42 AEDT 2019::INFO::Reading file "input-data.csv" as the source of data ...
  Tue Dec 10 22:27:42 AEDT 2019::INFO::The input CSV file contains 92 rows and 18 columns.
  Tue Dec 10 22:27:42 AEDT 2019::INFO::The field(s) for sorting: ENTRY_NO, PH_cm, EH_cm
  
  output:
  - row: 2
    column: 2
    data: ENTRY_NO=46 PH_cm=280 EH_cm=160
  - row: 8
    column: 9
    data: ENTRY_NO=46 PH_cm=250 EH_cm=150
  - row: 6
    column: 3
    data: ENTRY_NO=45 PH_cm=189 EH_cm=128
  
  Tue Dec 10 22:27:42 AEDT 2019::INFO::All tasks are done.
~~~

## Something you need to know

- **The input csv-file must be placed in the same folder as the sorting-tool.jar**

- **If a field for sorting contains a whitespace, use double quotation marks on it**
~~~
  $ java -jar sorting-tool.jar "GW_g__ FieldWB"
~~~

- **When utilising the indicator -h for help, all other arguments will be ignored**

- **When utilising indicator -f or -r, then the indicator -o become mandatory**
~~~
  $ java -jar sorting-tool.jar -f input-data-ex.csv -o Moi_pct__STD
~~~
&emsp;&emsp;**Please refer the section "Advanced Usages" for more detail**  

## Advanced Usages  

- **Use indicator "-h" to get the instruction of this tool**
~~~
  $ java -jar sorting-tool.jar -h
~~~

- **Use indicator "-f" to specify the input csv file**
~~~
  $ java -jar sorting-tool.jar -f input-data-ex.csv -o ENTRY_NO 
~~~

- **Use indicator "-r" to get reversely ordered results**
~~~
 $ java -jar sorting-tool.jar -r -o ENTRY_NO 
~~~

- **The order of the indicators appearing on the command line is not a matter**
~~~
  $ java -jar sorting-tool.jar -f input-data-ex.csv -o ENTRY_NO -r 
~~~
~~~
  $ java -jar sorting-tool.jar -r -o ENTRY_NO -f input-data-ex.csv 
~~~
&emsp;&emsp;**Above two usages are equivalent**

## Project Structure

~~~
  java-sorting-tool
  |- src
  |  |- diversity.arrays        # package namespace
  |  |  |- ArgsParser           # parsing and verifying arguments
  |  |  |- FileHolder           # reading file and checking data completeness
  |  |  |- DataHolder           # data unit to hold one line data in the csv file
  |  |  |- DeepCompare          # core comparing algorithm for sorting
  |  |  |- SortingTool          # main class of the tool
  |  |  |- LogFormatter         # formatter for tool's log recorder
  |  |  `- ToolLogger           # log recorder of the tool
  |  `- Makefile                # makefile to compile classes and build the .jar package
  |- input-data.csv             # default input file
  |- sorting-tool.jar           # archive version of this tool to release
  |- README.md                  # current file
  |- test-cases-v1.md           # test cases for the first round
  |- text-cases-v2.md           # test cases for the second round
  `- logger.log                 # auto generated log file
~~~

## How To Build  

- **Enter the folder "src"**
~~~
  $ cd src
~~~

- **Compile all the classes by**
~~~
  $ make
~~~

- **Build archive version of the tool by**
~~~
 $ make install
~~~
&emsp;&ensp;*Note: the .jar file will be placed in the root folder of the project*

- **Clean up all \*.class files by**
~~~
 $ make clean
~~~